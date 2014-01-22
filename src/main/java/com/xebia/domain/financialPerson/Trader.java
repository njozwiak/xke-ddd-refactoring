package com.xebia.domain.financialPerson;

public final class Trader extends FinancialPerson {

    protected Trader() {
    }

    public Trader(String identity, String lastname, String email) {
        super(identity, lastname, email);
    }
}
