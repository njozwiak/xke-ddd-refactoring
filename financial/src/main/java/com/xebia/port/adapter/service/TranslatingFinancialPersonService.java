package com.xebia.port.adapter.service;

import com.xebia.domain.financialPerson.FinancialPersonService;

public class TranslatingFinancialPersonService implements FinancialPersonService {

    private UserAdapter userAdapter;

    public TranslatingFinancialPersonService(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }
}
