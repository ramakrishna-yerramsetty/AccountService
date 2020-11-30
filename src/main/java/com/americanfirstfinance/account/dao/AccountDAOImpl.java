package com.americanfirstfinance.account.dao;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.dao.persistence.Transaction;
import com.americanfirstfinance.account.dao.persistence.TransactionType;
import com.americanfirstfinance.account.form.CustomerPayment;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    private final EntityManager entityManager;

    @Inject
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> getAccountListForDealer(String dealerId, int fromIndex, int maxItems) {
        Query query = entityManager.createQuery("select acct from Account acct where acct.dealer.dealerId = :dealerId").setParameter("dealerId", Integer.parseInt(dealerId));
        List<Account> accounts = query.getResultList();
        return accounts;
    }

    @Override
    public Account getAccount(String accountNumber) {
        /*return new Account(
                accountNumber,
                null,
                15,
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST,
                0.08,
                CurrencyUnit.USD.getCode(),
                100.0,
                1000.0,
                Collections.EMPTY_LIST
        );*/
        Account account = entityManager.find(Account.class, accountNumber);
        return account;
    }

    @Override
    public Transaction postCustomerPayment(CustomerPayment payment) {
        Account account = getAccount(payment.getAccountNumber());

        String confirmationNumber = UUID.randomUUID().toString();

        Transaction transaction = Transaction.builder()
                .confirmationNumber(confirmationNumber)
                .account(account)
                .datePosted(ZonedDateTime.now())
                .transactionType(TransactionType.DOWN_PAYMENT)
                .description("Down payment")
                .currencyCode(payment.getCurrencyCode())
                .amount(payment.getAmount())
                .build();

        account.setBalance(account.getBalance() - payment.getAmount());

        persistTransaction(account, transaction);

        return transaction;
    }

    @Transactional
    public void persistTransaction(Account account, Transaction transaction) {
        entityManager.merge(account);
        entityManager.merge(transaction);
    }
}
