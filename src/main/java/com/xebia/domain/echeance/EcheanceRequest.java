package com.xebia.domain.echeance;


import com.xebia.domain.ProductDecimal;
import com.xebia.domain.model.IdValueObject;

import java.math.BigDecimal;
import java.util.Date;

public class EcheanceRequest extends IdValueObject {

    private Date beginDate;

    private Date endDate;

    private ProductDecimal crd;

    private BigDecimal reoffer;

    private boolean active = true;

    protected EcheanceRequest() {
      super();
    }

    public EcheanceRequest(Date beginDate, Date endDate, ProductDecimal crd, BigDecimal reoffer) {
        this.setBeginDate(beginDate);
        this.setEndDate(endDate);
        this.setCrd(crd);
        this.setReoffer(reoffer);
    }

    public Date beginDate() {
        return beginDate;
    }

    public Date endDate() {
        return endDate;
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

    protected void setBeginDate(Date beginDate) {
      this.beginDate = beginDate;
    }

    protected void setEndDate(Date endDate) {
      this.endDate = endDate;
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
