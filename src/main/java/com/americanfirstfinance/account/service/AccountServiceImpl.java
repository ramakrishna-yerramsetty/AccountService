package com.americanfirstfinance.account.service;

import com.americanfirstfinance.account.dao.AccountDAO;
import com.americanfirstfinance.account.domain.Account;
import com.americanfirstfinance.account.domain.AccountSummary;
import com.americanfirstfinance.account.domain.Customer;
import com.americanfirstfinance.account.domain.Transaction;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.format.MoneyPrinter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {
    //keep it relatively small to show off pagination
    private static final int MAX_RESULTS_PER_PAGE = 20;

    private final AccountDAO accountDAO;

    @Inject
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    //Handles the Account List endpoint
    @Override
    public List<AccountSummary> getAccountsForDealer(String dealerId, int page) {
        List<Account> accountList = accountDAO.getAccountListForDealer(dealerId, page * MAX_RESULTS_PER_PAGE, MAX_RESULTS_PER_PAGE);

        return accountList.stream().map(this::transformAccountToSummaryView).collect(Collectors.toList());
    }

    private AccountSummary transformAccountToSummaryView(Account account) {
        List<String> primaryAccountHolders = summarizeCustomerList(account.getPrimaryAccountHolders());
        List<String> coSigners = summarizeCustomerList(account.getCosigners());
        Transaction lastPayment = account.getLastPayment();

        //This could be a builder instead of a constructor, but I want to make sure everything is set...
        return new AccountSummary(
            account.getAccountNumber(),
            account.getDealer().getName(),
            primaryAccountHolders,
            coSigners,
            account.getBalance(),
            lastPayment == null ? Money.of(CurrencyUnit.USD, BigDecimal.ZERO) : lastPayment.getAmount(),
            lastPayment == null ? null : lastPayment.getDatePosted()
        );
    }

    private List<String> summarizeCustomerList(List<Customer> customerList) {
       return customerList.stream().map(customer -> customer.getLastName() + ", " + customer.getFirstName().charAt(0)).collect(Collectors.toList());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.getAccount(accountNumber);
    }
}
