package com.xebia.domain.product;

import com.xebia.domain.commission.CommissionBook;
import com.xebia.domain.currency.CurrencyBook;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBook;
import com.xebia.domain.model.Entity;

import java.util.Date;

public class Product extends Entity {

    private ProductId productId;
    private String name;
    private String referenceCode;
    private String technicalCode;
    private Date marketDate;
    private Date placeDate;

    private EcheanceRequestBook echeanceRequestBook = new EcheanceRequestBook();
    private CurrencyBook currencyBook = new CurrencyBook();
    private CommissionBook commissionBook = new CommissionBook();

    public CommissionBook getCommissionBook() {
        return commissionBook;
    }

    public void setCommissionBook(CommissionBook commissionBook) {
        this.commissionBook = commissionBook;
    }

    public CurrencyBook getCurrencyBook() {
        return currencyBook;
    }

    public void setCurrencyBook(CurrencyBook currencyBook) {
        this.currencyBook = currencyBook;
    }

    public EcheanceRequestBook getEcheanceRequestBook() {
        return echeanceRequestBook;
    }

    public void setEcheanceRequestBook(EcheanceRequestBook echeanceRequestBook) {
        this.echeanceRequestBook = echeanceRequestBook;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getTechnicalCode() {
        return technicalCode;
    }

    public void setTechnicalCode(String technicalCode) {
        this.technicalCode = technicalCode;
    }

    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }

    public Date getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(Date placeDate) {
        this.placeDate = placeDate;
    }

    public void addEcheance(EcheanceRequest echeanceRequest) {
        echeanceRequestBook.getEcheanceRequests().add(echeanceRequest);
    }
}
