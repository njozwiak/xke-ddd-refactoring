package com.xebia.domain.commission;

import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.currency.Currency;

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
        if (currency == montant.currency) {
            return new Montant(value.add(montant.value), montant.currency);
        } else {
            throw new MontantException();
        }
    }

}
