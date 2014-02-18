package com.xebia.domain.currency;

import com.xebia.model.IdValueObject;

public class Currency extends IdValueObject {

    public static final String EUR_ISO = "EUR";

    public static final String USD_ISO = "USD";

    private String name;

    private String isoCode;

    protected Currency() {
        super();
    }

    public Currency(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    public String name() {
        return name;
    }

    public String isoCode() {
        return isoCode;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public boolean equals(Currency currency) {
        return this.isoCode().equalsIgnoreCase(currency.isoCode());
    }

    public boolean isFundingCurrency() {
        return EUR_ISO.equals(this.isoCode) || USD_ISO.equals(this.isoCode);
    }
}
