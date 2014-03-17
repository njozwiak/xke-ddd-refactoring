package com.xebia.domain.echeance;

import com.xebia.domain.currency.Currency;
import com.xebia.domain.exception.MontantException;

public class Montant {

    private CreditDecimal value;

    private Currency currency;

    public Montant() {
    }

    public Montant(CreditDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public CreditDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Montant add(Montant montant) throws MontantException {
        if (this.currency.equals(montant.getCurrency())) {
            CreditDecimal newValue = this.getValue().add(montant.getValue());
            return new Montant(newValue, this.getCurrency());
        } else {
            throw new MontantException("cannot add montant with different currencies");
        }

    }
}
