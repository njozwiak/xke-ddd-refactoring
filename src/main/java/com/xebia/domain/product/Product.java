package com.xebia.domain.product;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.xebia.domain.comission.Comission;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.currency.CurrencyBook;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBook;
import com.xebia.domain.model.Entity;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class Product extends Entity {

    private ProductId productId;

    private String name;

    private String technicalCode;

    private Date marketDate;

    private Date placeDate;

    private EcheanceRequestBook echeanceRequestBook = new EcheanceRequestBook();

    private CurrencyBook currencyBook = new CurrencyBook();

    private List<Comission> comissions = Lists.newArrayList();

    public Product(ProductId productId, String name, String technicalCode) {
        this.setProductId(productId);
        this.setName(name);
        this.setTechnicalCode(technicalCode);
    }

    protected Product() {
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        checkArgument(productId != null, "ProductId is required");
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Comission> getComissions() {
        return comissions;
    }

    public void setComissions(List<Comission> comissions) {
        this.comissions = comissions;
    }

    public void addEcheance(EcheanceRequest echeanceRequest) {
        this.echeanceRequestBook.getEcheanceRequests().add(echeanceRequest);
    }

    public CurrencyBook getCurrencyBook() {
        return currencyBook;
    }

    public void addCurrency(Currency currency) {
        this.currencyBook.getCurrencies().add(currency);
    }

    @Override
    public boolean equals(Object object) {
        boolean equalObjects = false;

        if (object != null && this.getClass() == object.getClass()) {
            Product typedObject = (Product) object;
            equalObjects =
                    this.productId.equals(typedObject.productId) &&
                            this.name.equals(typedObject.name) &&
                            this.technicalCode.equals(typedObject.technicalCode);
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId, name, technicalCode);
    }

    public List<EcheanceRequest> getEcheanceRequestActive() {
        return this.echeanceRequestBook.getEcheanceRequestActive();
    }

}
