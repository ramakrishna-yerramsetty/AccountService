package com.americanfirstfinance.account.dao;

import com.americanfirstfinance.account.domain.Account;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @Override
    public List<Account> getAccountListForDealer(String dealerId, int fromIndex, int maxItems) {
        return Collections.emptyList();
    }

    @Override
    public Account getAccount(String accountNumber) {
        return new Account(
                accountNumber,
                null,
                15,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                0.08,
                Money.of(CurrencyUnit.USD, 100.0),
                Money.of(CurrencyUnit.USD, 1000.0),
                Collections.EMPTY_LIST
        );
    }
}
