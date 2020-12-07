package com.americanfirstfinance.account.dao;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.dao.persistence.Transaction;
import com.americanfirstfinance.account.form.DownPayment;

import java.util.List;

public interface AccountDAO {
    List<Account> getAccountListForDealer(String dealerId, int fromIndex, int maxItems);
    Account getAccount(String customerNumber, String accountId);
    Transaction postCustomerPayment(DownPayment payment);
}
