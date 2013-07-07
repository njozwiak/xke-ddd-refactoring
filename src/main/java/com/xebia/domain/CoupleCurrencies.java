package com.xebia.domain;

public class CoupleCurrencies {

    private Currency currentCurrency;

    private Currency counterCurrency;

    public Boolean isSameCurrency() {
        return currentCurrency.equals(counterCurrency);
    }
}
