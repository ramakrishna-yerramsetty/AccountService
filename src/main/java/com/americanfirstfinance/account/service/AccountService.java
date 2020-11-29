package com.americanfirstfinance.account.service;

import com.americanfirstfinance.account.domain.Account;
import com.americanfirstfinance.account.domain.AccountSummary;

import java.util.List;

public interface AccountService {
    List<AccountSummary> getAccountsForDealer(String dealerId, int page);
    Account getAccount(String accountNumber);
}
