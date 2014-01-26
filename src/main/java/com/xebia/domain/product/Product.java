package com.xebia.domain.product;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import com.xebia.domain.comission.Comission;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
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

    private List<EcheanceRequest> echeanceRequests = Lists.newArrayList();

    private List<Currency> currencies = Lists.newArrayList();

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

    public List<EcheanceRequest> getEcheanceRequests() {
        return echeanceRequests;
    }

    public void setEcheanceRequests(List<EcheanceRequest> echeanceRequests) {
        this.echeanceRequests = echeanceRequests;
    }

    public void addEcheance(EcheanceRequest echeanceRequest) {
        this.echeanceRequests.add(echeanceRequest);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
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
        Iterable<EcheanceRequest> activeEcheances = Iterables.filter(getEcheanceRequests(), new Predicate<EcheanceRequest>() {
            @Override
            public boolean apply(EcheanceRequest echeanceRequest) {
                return echeanceRequest.getActive();
            }
        });

        return Lists.newArrayList(activeEcheances);
    }

}
