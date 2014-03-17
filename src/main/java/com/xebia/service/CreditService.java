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

    public List<EcheanceRequest> valuationCredit(Credit credit, Date valueDate) {
        List<EcheanceRequest> echeanceRequestActive = credit.getEcheanceRequestActive();
        List<EcheanceRequest> echeanceRequestValuations = Lists.newArrayList();

        for (EcheanceRequest echeanceRequest : echeanceRequestActive) {
            EcheanceRequest echeanceRequestValuation = new EcheanceRequest();

            BigDecimal creditValuation = echeanceRequest.getCrd();

            if (containsFundingCurrencies(credit.getCurrencies())) {
                creditValuation = applyCrossChange(creditValuation, valueDate);
            }

            echeanceRequestValuation.setPaymentDate(echeanceRequest.getPaymentDate());
            echeanceRequestValuation.setCrd(creditValuation);

            echeanceRequestValuations.add(echeanceRequestValuation);
        }

        return echeanceRequestValuations;
    }

    public void addEcheanceToCredit(Long creditId, EcheanceRequest echeance) {
        Credit credit = creditRepository.findOne(creditId);
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
