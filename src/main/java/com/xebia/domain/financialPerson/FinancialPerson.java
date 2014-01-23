package com.xebia.domain.financialPerson;

public abstract class FinancialPerson {

    private String name;
    private String email;

    protected FinancialPerson() {
    }

    public FinancialPerson(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String lastname() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
