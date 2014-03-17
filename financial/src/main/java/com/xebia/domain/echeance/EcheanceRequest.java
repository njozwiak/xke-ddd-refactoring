package com.xebia.domain.echeance;


import com.xebia.model.IdValueObject;

import java.util.Date;

public class EcheanceRequest extends IdValueObject {

    private Date paymentDate;

    private CreditDecimal crd;

    private boolean active = true;

    protected EcheanceRequest() {
        super();
    }

    public EcheanceRequest(Date paymentDate, CreditDecimal crd) {
        this.paymentDate = paymentDate;
        this.setCrd(crd);
    }

    public CreditDecimal crd() {
        return crd;
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

    protected void setCrd(CreditDecimal crd) {
        this.crd = crd;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }

    public void disable() {
        this.setActive(false);
    }

}
