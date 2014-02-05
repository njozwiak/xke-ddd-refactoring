package com.xebia.domain.echeance;


import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

public class EcheanceRequestBook {

    private List<EcheanceRequest> echeanceRequests = Lists.newArrayList();

    public List<EcheanceRequest> getEcheanceRequests() {
        return echeanceRequests;
    }

    public List<EcheanceRequest> getEcheanceRequestActive() {
        Iterable<EcheanceRequest> activeEcheances = Iterables.filter(getEcheanceRequests(), new Predicate<EcheanceRequest>() {
            @Override
            public boolean apply(EcheanceRequest echeanceRequest) {
                return echeanceRequest.getActive();
            }
        });

        return Lists.newArrayList(activeEcheances);
    }

}
