package com.xebia.domain.product;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.xebia.domain.ProductDecimal;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBuilder;
import com.xebia.port.adapter.service.ProductDataService;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

public class ProductService {

    private ProductDataService dataService;

    @Inject
    public ProductService(ProductDataService dataService) {
        this.dataService = dataService;
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

            EcheanceRequest echeanceRequestValorise = new EcheanceRequestBuilder().beginDate(echeanceRequest.beginDate())
                                                                                  .endDate(echeanceRequest.endDate())
                                                                                  .crd(crdValorise)
                                                                                  .reoffer(echeanceRequest.reoffer())
                                                                                  .build();
            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
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
                return echeanceRequest.beginDate().after(date);
            }
        })).size();
    }

}
