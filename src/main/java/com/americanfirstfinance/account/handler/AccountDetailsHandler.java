package com.americanfirstfinance.account.handler;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.service.AccountService;
import com.americanfirstfinance.account.view.AccountDetailsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.NumberFormat;

@ApplicationScoped
public class AccountDetailsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsHandler.class);

    private final AccountService accountService;

    @Inject
    public AccountDetailsHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountDetailsView getAccountDetails(String customerNumber, String accountId) {
        return buildAccountDetailsView(accountService.getAccount(customerNumber, accountId));
    }

    private AccountDetailsView buildAccountDetailsView(Account account) {
        if (account == null) {
            return null;
        }

        return AccountDetailsView.builder()
                .accountNumber(account.getFormattedAccountNumber().trim())
                .customerNumber(Integer.toString(account.getAccountNumber().getCustomerNumber()))
                .accountId(Integer.toString(account.getAccountNumber().getAccountId()))
                .dealerId(account.getDealerId().trim())
                .dealerLocation(account.getDealearLocation().trim())
                .customerFirstName(account.getFirstName().trim())
                .customerLastName(account.getLastName().trim())
                .accountProduct(account.getProduct().trim())
                .accountType(account.getType().trim())
                .dueDateOfMonth(Integer.toString(account.getPaymentDueDayOfMonth()))
                .currentBalance(NumberFormat.getCurrencyInstance().format(account.getBalance()))
                .creditLimit(NumberFormat.getCurrencyInstance().format(account.getLine()))
                .build();
    }

}
