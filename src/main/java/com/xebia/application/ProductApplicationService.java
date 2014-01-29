package com.xebia.application;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.xebia.domain.ProductDecimal;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBuilder;
import com.xebia.domain.product.Product;
import com.xebia.domain.product.ProductRepository;
import com.xebia.port.adapter.service.ProductDataService;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

@Transactional
public class ProductApplicationService {

    private ProductDataService dataService;

    private ProductRepository productRepository;

    @Inject
    public ProductApplicationService(ProductDataService dataService, ProductRepository productRepository) {
        this.dataService = dataService;
        this.productRepository = productRepository;
    }

    public List<EcheanceRequest> valoriseProduct(Product product, Date dateValorisation) {

        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValorises = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            ProductDecimal fixingPourDate = dataService.getFixingPourDate(dateValorisation);

            ProductDecimal crdValorise = echeanceRequest.crd().multiply(fixingPourDate);

            if (containsFundingCurrencies(product.getCurrencyBook().getCurrencies())) {
                crdValorise = convertirEnDevise(crdValorise, dateValorisation);
            }

            EcheanceRequest echeanceRequestValorise = new EcheanceRequestBuilder().withPaymentDate(echeanceRequest.paymentDate())
                    .withCrd(crdValorise)
                    .withReoffer(echeanceRequest.reoffer())
                    .build();
            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
    }

    public void addEcheanceToProduct(Long idProduct, EcheanceRequest echeanceRequest) {
        Product product = productRepository.findOne(idProduct);

        product.addEcheance(echeanceRequest);
    }

    ProductDecimal convertirEnDevise(ProductDecimal value, Date date) {
        ProductDecimal crossChange = dataService.getCrossChange(date);
        return value.divide(crossChange);
    }

    Boolean containsFundingCurrencies(List<Currency> currencies) {
        return Iterables.any(currencies, new Predicate<Currency>() {
            @Override
            public boolean apply(Currency currency) {
                return currency.isFundingCurrency();
            }
        });
    }

    Integer countRemainingEcheanceAfter(Product product, final Date date) {
        return Lists.newArrayList(Iterables.filter(product.getEcheanceRequestActive(), new Predicate<EcheanceRequest>() {
            @Override
            public boolean apply(@Nullable EcheanceRequest echeanceRequest) {
                return echeanceRequest.paymentDate().after(date);
            }
        })).size();
    }

}
