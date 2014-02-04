package com.xebia.domain;

import com.xebia.domain.model.IdValueObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class EcheanceRequest extends IdValueObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date paymentDate;

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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
