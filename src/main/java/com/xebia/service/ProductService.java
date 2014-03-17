package com.xebia.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.xebia.domain.Currency;
import com.xebia.domain.EcheanceRequest;
import com.xebia.domain.Product;
import com.xebia.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
public class ProductService {

    public DataService dataService;

    public ProductRepository productRepository;

    @Inject
    public ProductService(DataService dataService, ProductRepository productRepository) {
        this.dataService = dataService;
        this.productRepository = productRepository;
    }

    public List<EcheanceRequest> valoriseProduct(Product product, Date dateValorisation) {
        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValorises = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            EcheanceRequest echeanceRequestValorise = new EcheanceRequest();

            BigDecimal crdValorise = echeanceRequest.getCrd();

            if (containsFundingCurrencies(product.getCurrencies())) {
                crdValorise = applyCrossChange(crdValorise, dateValorisation);
            }

            echeanceRequestValorise.setPaymentDate(echeanceRequest.getPaymentDate());
            echeanceRequestValorise.setCrd(crdValorise);

            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
    }

    public void addEcheanceToProduct(Long productId, EcheanceRequest echeance) {
        Product product = productRepository.findOne(productId);
        product.getEcheanceRequests().add(echeance);
    }

    public BigDecimal applyCrossChange(BigDecimal value, Date date) {
        if (value != null) {
            BigDecimal crossChange = dataService.getCrossChange(date);

            return value.divide(crossChange);
        }

        return value;
    }

    Boolean containsFundingCurrencies(List<Currency> currencies) {
        return Iterables.any(currencies, new Predicate<Currency>() {
            @Override
            public boolean apply(Currency currency) {
                if (!"EUR".equalsIgnoreCase(currency.getIsoCode()) && !"USD".equalsIgnoreCase(currency.getIsoCode())) {
                    return false;
                }
                return true;
            }
        });
    }

}
