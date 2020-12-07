package com.americanfirstfinance.account.service;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.form.DownPayment;
import com.americanfirstfinance.account.view.AccountSummaryView;
import com.americanfirstfinance.account.view.Receipt;

import java.util.List;

public interface AccountService {
    List<AccountSummaryView> getAccountsForDealer(String dealerId, int page);
    Account getAccount(String customerNumber, String accountId);
    Receipt postDownPayment(DownPayment payment);
}
