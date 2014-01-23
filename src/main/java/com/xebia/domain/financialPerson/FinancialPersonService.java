package com.xebia.domain.financialPerson;

import com.xebia.domain.user.User;

public interface FinancialPersonService {

    Sales salesFrom(User user);

    Pricer pricerFrom(User user);

    Trader traderFrom(User user);
}
