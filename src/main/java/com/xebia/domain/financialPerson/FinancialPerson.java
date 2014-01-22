package com.xebia.domain.financialPerson;

public abstract class FinancialPerson {

    private String identity;
    private String lastname;
    private String email;

    protected FinancialPerson() {
    }

    public FinancialPerson(String identity, String lastname, String email) {
        this.identity = identity;
        this.lastname = lastname;
        this.email = email;
    }

    public String identity() {
        return identity;
    }

    public String lastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    private void setIdentity(String identity) {
        this.identity = identity;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
