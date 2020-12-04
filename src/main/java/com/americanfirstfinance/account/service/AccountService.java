package com.americanfirstfinance.account.service;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.form.CustomerPayment;
import com.americanfirstfinance.account.view.AccountSummary;
import com.americanfirstfinance.account.view.Receipt;

import java.util.List;

public interface AccountService {
    List<AccountSummary> getAccountsForDealer(String dealerId, int page);
    Account getAccount(String accountNumber);
    //Receipt postDownPayment(CustomerPayment payment);
}
