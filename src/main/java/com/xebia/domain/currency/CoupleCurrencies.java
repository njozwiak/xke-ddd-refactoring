package com.xebia.domain.currency;

public class CoupleCurrencies {

    private Currency currentCurrency;

    private Currency counterCurrency;

    public Boolean isSameCurrency() {
        return currentCurrency.equals(counterCurrency);
    }
}
