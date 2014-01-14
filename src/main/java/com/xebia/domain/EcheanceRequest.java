package com.xebia.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class EcheanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date beginDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Product product;

    private BigDecimal crd;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getCrd() {
        return crd;
    }

    public void setCrd(BigDecimal crd) {
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
