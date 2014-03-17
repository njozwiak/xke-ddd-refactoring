package com.xebia.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.xebia.domain.Credit;
import com.xebia.domain.Currency;
import com.xebia.domain.EcheanceRequest;
import com.xebia.repository.CreditRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
public class CreditService {

    public DataService dataService;

    public CreditRepository creditRepository;

    @Inject
    public CreditService(DataService dataService, CreditRepository creditRepository) {
        this.dataService = dataService;
        this.creditRepository = creditRepository;
    }

    public List<EcheanceRequest> valoriseProduct(Credit credit, Date dateValorisation) {
        List<EcheanceRequest> echeanceRequestActive = credit.getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValorises = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            EcheanceRequest echeanceRequestValorise = new EcheanceRequest();

            BigDecimal crdValorise = echeanceRequest.getCrd();

            if (containsFundingCurrencies(credit.getCurrencies())) {
                crdValorise = applyCrossChange(crdValorise, dateValorisation);
            }

            echeanceRequestValorise.setPaymentDate(echeanceRequest.getPaymentDate());
            echeanceRequestValorise.setCrd(crdValorise);

            echeanceRequestValorises.add(echeanceRequestValorise);
        }

        return echeanceRequestValorises;
    }

    public void addEcheanceToProduct(Long productId, EcheanceRequest echeance) {
        Credit credit = creditRepository.findOne(productId);
        credit.getEcheanceRequests().add(echeance);
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
