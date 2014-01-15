package com.xebia.domain.product;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.ProductDecimal;
import com.xebia.service.ProductDataService;

import java.util.Date;
import java.util.List;

public class ProductService {

    public ProductDataService dataService;

    @Inject
    public ProductService(ProductDataService dataService) {
        this.dataService = dataService;
    }

    public List<EcheanceRequest> valoriseProduct(Product product, Date dateValorisation) {

        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValorises = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            ProductDecimal fixingPourDate = dataService.getFixingPourDate(dateValorisation);

            EcheanceRequest echeanceRequestValorise = new EcheanceRequest();
            echeanceRequestValorise.setBeginDate(echeanceRequest.getBeginDate());
            echeanceRequestValorise.setEndDate(echeanceRequest.getEndDate());

            ProductDecimal crdValorise = echeanceRequest.getCrd().multiply(fixingPourDate);

            if (containsFundingCurrencies(product.getCurrencies())) {
                crdValorise = convertirEnDevise(crdValorise, dateValorisation);
            }

            echeanceRequestValorise.setCrd(crdValorise);
            echeanceRequestValorise.setReoffer(echeanceRequest.getReoffer());

            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
    }

    public ProductDecimal convertirEnDevise(ProductDecimal value, Date date) {
        ProductDecimal crossChange = dataService.getCrossChange(date);

        return value.divide(crossChange);
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