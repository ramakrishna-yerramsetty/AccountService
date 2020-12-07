package com.americanfirstfinance.account.service;

import com.americanfirstfinance.account.dao.AccountDAO;
import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.dao.persistence.Transaction;
import com.americanfirstfinance.account.form.DownPayment;
import com.americanfirstfinance.account.view.AccountSummaryView;
import com.americanfirstfinance.account.view.Receipt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.NumberFormat;
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
    public List<AccountSummaryView> getAccountsForDealer(String dealerId, int page) {
        List<Account> accountList = accountDAO.getAccountListForDealer(dealerId, page * MAX_RESULTS_PER_PAGE, MAX_RESULTS_PER_PAGE);

        return accountList.stream().map(this::transformAccountToSummaryView).collect(Collectors.toList());
    }

    private AccountSummaryView transformAccountToSummaryView(Account account) {
        //This could be a builder instead of a constructor, but I want to make sure everything is set...
        //Return new AccountSummary(
        return new AccountSummaryView(
            account.getFormattedAccountNumber(),
            account.getDealerId().trim(),
                account.getFirstName().trim(),
                account.getLastName().trim(),
                NumberFormat.getCurrencyInstance().format(account.getBalance()),
                NumberFormat.getCurrencyInstance().format(account.getLine())
        );
    }

    @Override
    public Account getAccount(String customerNumber, String accountId) {
        return accountDAO.getAccount(customerNumber, accountId);
    }

    @Override
    public Receipt postDownPayment(DownPayment payment) {
        Transaction paymentTransaction = accountDAO.postCustomerPayment(payment);
        return generatePaymentReceipt(paymentTransaction);
    }

    private Receipt generatePaymentReceipt(Transaction paymentTransaction) {
        Receipt receipt = new Receipt(paymentTransaction.getDecision());
        return receipt;
    }
}
