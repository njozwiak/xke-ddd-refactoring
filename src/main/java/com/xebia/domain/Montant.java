package com.xebia.domain;

import com.xebia.domain.currency.Currency;
import com.xebia.domain.exception.MontantException;

public class Montant {

    private ProductDecimal value;

    private Currency currency;

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
        if (this.currency.equals(montant.getCurrency())) {
            ProductDecimal newValue = this.getValue().add(montant.getValue());
            return new Montant(newValue, this.getCurrency());
        } else {
            throw new MontantException("cannot add montant with different currencies");
        }

    }
}
