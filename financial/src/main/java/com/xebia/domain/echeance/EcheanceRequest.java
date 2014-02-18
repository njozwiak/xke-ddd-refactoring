package com.xebia.domain.echeance;


import com.xebia.model.IdValueObject;

import java.math.BigDecimal;
import java.util.Date;

public class EcheanceRequest extends IdValueObject {

    private Date paymentDate;

    private ProductDecimal crd;

    private BigDecimal reoffer;

    private boolean active = true;

    protected EcheanceRequest() {
        super();
    }

    public EcheanceRequest(Date paymentDate, ProductDecimal crd, BigDecimal reoffer) {
        this.paymentDate = paymentDate;
        this.setCrd(crd);
        this.setReoffer(reoffer);
    }

    public ProductDecimal crd() {
        return crd;
    }

    public BigDecimal reoffer() {
        return reoffer;
    }

    public boolean active() {
        return active;
    }

    public Date paymentDate() {
        return paymentDate;
    }

    protected void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    protected void setCrd(ProductDecimal crd) {
        this.crd = crd;
    }

    protected void setReoffer(BigDecimal reoffer) {
        this.reoffer = reoffer;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }

    public void disable() {
        this.setActive(false);
    }

}
