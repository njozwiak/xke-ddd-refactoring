package com.xebia.domain.echeance;

import com.xebia.domain.model.Entity;
import com.xebia.domain.product.Product;

import java.math.BigDecimal;
import java.util.Date;

// TODO 1.2 move into the appropriate package

public class EcheanceRequest extends Entity {

    private Date paymentDate;

    private Product product;

    private ProductDecimal crd;

    private BigDecimal reoffer;

    private boolean active;

    public EcheanceRequest() {
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
