package com.xebia.domain.echeance;

import com.xebia.domain.currency.Currency;
import com.xebia.domain.exception.MontantException;

public class Amount {

    private CreditDecimal value;

    private Currency currency;

    public Amount() {
    }

    public Amount(CreditDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public CreditDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Amount add(Amount amount) throws MontantException {
        if (this.currency.equals(amount.getCurrency())) {
            CreditDecimal newValue = this.getValue().add(amount.getValue());
            return new Amount(newValue, this.getCurrency());
        } else {
            throw new MontantException("cannot add amount with different currencies");
        }

    }
}
