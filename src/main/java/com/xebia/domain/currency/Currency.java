package com.xebia.domain.currency;

public class Currency {

    public static final String EUR_ISO = "EUR";

    public static final String USD_ISO = "USD";

    private Long id;

    private String name;

    private String isoCode;

    public Currency() {
    }

    public Currency(Long id, String name, String isoCode) {
        this.id = id;
        this.name = name;
        this.isoCode = isoCode;
    }

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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public boolean equals(Currency currency) {
        return this.getIsoCode().equalsIgnoreCase(currency.getIsoCode());
    }
}
