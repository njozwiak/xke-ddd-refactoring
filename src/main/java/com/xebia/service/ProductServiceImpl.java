package com.xebia.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.product.Product;
import com.xebia.domain.product.ProductRepository;
import com.xebia.domain.product.ProductService;
import com.xebia.port.adapter.service.DataService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
public class ProductServiceImpl implements ProductService {

    public DataService dataService;

    public ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(DataService dataService, ProductRepository productRepository) {
        this.dataService = dataService;
        this.productRepository = productRepository;
    }

    @Override
    public List<EcheanceRequest> valoriseProduct(Product product, Date dateValorisation) {
        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestBook().getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValorises = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            BigDecimal fixingPourDate = dataService.getFixingPourDate(dateValorisation);

            EcheanceRequest echeanceRequestValorise = new EcheanceRequest();

            BigDecimal crdValorise = null;
            if (echeanceRequest.getCrd() != null) {
                crdValorise = echeanceRequest.getCrd().multiply(fixingPourDate);
            }

            if (containsFundingCurrencies(product.getCurrencyBook().getCurrencies())) {
                crdValorise = applyCrossChange(crdValorise, dateValorisation);
            }

            echeanceRequestValorise.setPaymentDate(echeanceRequest.getPaymentDate());
            echeanceRequestValorise.setCrd(new ProductDecimal( crdValorise));
            echeanceRequestValorise.setReoffer(echeanceRequest.getReoffer());

            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
    }

    @Override
    public void addEcheanceToProduct(Long productId, EcheanceRequest echeance) {
        Product product = productRepository.findOne(productId);
        product.getEcheanceRequestBook().getEcheanceRequests().add(echeance);
    }

    @Override
    public BigDecimal applyCrossChange(BigDecimal value, Date date) {
        if (value != null) {
            BigDecimal crossChange = dataService.getCrossChange(date);

            return value.divide(crossChange);
        }

        return value;
    }

    @Override
    public Boolean containsFundingCurrencies(List<Currency> currencies) {
        return Iterables.any(currencies, new Predicate<Currency>() {
            @Override
            public boolean apply(Currency currency) {
                if (!"EUR".equalsIgnoreCase(currency.isoCode()) && !"USD".equalsIgnoreCase(currency.isoCode())) {
                    return false;
                }
                return true;
            }
        });
    }

}
