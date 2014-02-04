package com.xebia.domain.echeance;

import com.xebia.domain.EcheanceRequest;

import java.math.BigDecimal;
import java.util.Date;

public class EcheanceRequestBuilder {

    private EcheanceRequest echeanceRequest;

    public EcheanceRequestBuilder() {
        this.echeanceRequest = new EcheanceRequest();
        this.echeanceRequest.setActive(true);
    }

    public EcheanceRequest build() {
        return echeanceRequest;
    }

    public EcheanceRequestBuilder withPaymentDate(Date paymentDate) {
        echeanceRequest.setPaymentDate(paymentDate);
        return this;
    }

    public EcheanceRequestBuilder withCrd(ProductDecimal crd) {
        echeanceRequest.setCrd(crd);
        return this;
    }

    public EcheanceRequestBuilder withReoffer(BigDecimal reoffer) {
        echeanceRequest.setReoffer(reoffer);
        return this;
    }

    public EcheanceRequestBuilder isInactive() {
        echeanceRequest.setActive(false);
        return this;
    }
}
