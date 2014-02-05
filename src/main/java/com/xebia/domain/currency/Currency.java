package com.xebia.domain.currency;

import com.xebia.domain.model.ValueObject;

public class Currency extends ValueObject {

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

    public String name() {
        return name;
    }

    public String isoCode() {
        return isoCode;
    }

}
