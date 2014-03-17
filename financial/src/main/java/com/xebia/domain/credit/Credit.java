package com.xebia.domain.credit;

import com.google.common.base.Objects;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.currency.CurrencyBook;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBook;
import com.xebia.model.Entity;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class Credit extends Entity {

    private CreditId creditId;

    private String name;

    private String technicalCode;

    private Date marketDate;

    private Date placeDate;

    private EcheanceRequestBook echeanceRequestBook = new EcheanceRequestBook();

    private CurrencyBook currencyBook = new CurrencyBook();

    public Credit(CreditId creditId, String name, String technicalCode) {
        this.setCreditId(creditId);
        this.setName(name);
        this.setTechnicalCode(technicalCode);
    }

    protected Credit() {
    }

    public CreditId getCreditId() {
        return creditId;
    }

    public void setCreditId(CreditId creditId) {
        checkArgument(creditId != null, "CreditId is required");
        this.creditId = creditId;
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
            Credit typedObject = (Credit) object;
            equalObjects = this.creditId.equals(typedObject.creditId);
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(creditId);
    }

    public List<EcheanceRequest> getEcheanceRequestActive() {
        return this.echeanceRequestBook.getEcheanceRequestActive();
    }

}
