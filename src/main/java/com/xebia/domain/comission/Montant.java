package com.xebia.domain.comission;

import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.exception.MontantException;

public class Montant {

    private ProductDecimal value;

    private Currency currency;

    public Montant() {
    }

    public Montant(ProductDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public ProductDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Montant add(Montant montant) throws MontantException {
        //TODO

    }
}
