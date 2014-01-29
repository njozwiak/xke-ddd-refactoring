package com.xebia.domain.echeance;

import com.xebia.domain.ProductDecimal;

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

    public EcheanceRequestBuilder paymentDate(Date paymentDate) {
        echeanceRequest.setPaymentDate(paymentDate);
        return this;
    }

    public EcheanceRequestBuilder crd(ProductDecimal crd) {
        echeanceRequest.setCrd(crd);
        return this;
    }

    public EcheanceRequestBuilder reoffer(BigDecimal reoffer) {
        echeanceRequest.setReoffer(reoffer);
        return this;
    }

    public EcheanceRequestBuilder inactive() {
        echeanceRequest.setActive(false);
        return this;
    }
}
