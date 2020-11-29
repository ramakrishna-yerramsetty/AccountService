package com.americanfirstfinance.account.handler;

import com.americanfirstfinance.account.domain.Account;
import com.americanfirstfinance.account.service.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountDetailsHandler {

    private final AccountService accountService;

    @Inject
    public AccountDetailsHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account getAccountDetails(String accountNumber) {
        return accountService.getAccount(accountNumber);
    }

}
