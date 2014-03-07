package com.xebia.domain;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String referenceCode;

    private String technicalCode;

    private Date marketDate;

    private Date placeDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<EcheanceRequest> echeanceRequests = Lists.newArrayList();

    @OneToMany
    private List<Currency> currencies = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<EcheanceRequest> getEcheanceRequests() {
        return echeanceRequests;
    }

    public void setEcheanceRequests(List<EcheanceRequest> echeanceRequests) {
        this.echeanceRequests = echeanceRequests;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
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
