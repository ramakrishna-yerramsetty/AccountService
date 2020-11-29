package com.americanfirstfinance.account.dao;

import com.americanfirstfinance.account.domain.Account;

import java.util.Collections;
import java.util.List;

public interface AccountDAO {
    List<Account> getAccountListForDealer(String dealerId, int fromIndex, int maxItems);
    Account getAccount(String accountNumber);
}
