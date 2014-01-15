package com.xebia.domain.echeance;


import com.xebia.domain.ProductDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class EcheanceRequest {

    private Long id;

    private Date beginDate;

    private Date endDate;

    private ProductDecimal crd;

    private BigDecimal reoffer;

    private boolean active;

    public EcheanceRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ProductDecimal getCrd() {
        return crd;
    }

    public void setCrd(ProductDecimal crd) {
        this.crd = crd;
    }

    public BigDecimal getReoffer() {
        return reoffer;
    }

    public void setReoffer(BigDecimal reoffer) {
        this.reoffer = reoffer;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}