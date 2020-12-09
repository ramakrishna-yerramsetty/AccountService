package com.americanfirstfinance.account.dao;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.dao.persistence.AccountNumber;
import com.americanfirstfinance.account.dao.persistence.Transaction;
import com.americanfirstfinance.account.form.DownPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);
    private final EntityManager entityManager;

    @Inject
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> getAccountListForDealer(String dealerId, int fromIndex, int maxItems) {
        Query query = entityManager.createQuery("select acct from Account acct where acct.dealerId = :dealerId").setParameter("dealerId", dealerId).setFirstResult(fromIndex).setMaxResults(maxItems);
        List<Account> accounts = query.getResultList();
        return accounts;
    }

    @Override
    public Account getAccount(String customerNumber, String accountId) {
        LOGGER.info("AccountDAOImpl.getAccount() -- customerNumber: {} accountId: {}", customerNumber, accountId);
        Account account = entityManager.find(Account.class, new AccountNumber(Integer.parseInt(customerNumber), Integer.parseInt(accountId)));
        LOGGER.info("Got an account back? {}", account == null ? "No" : "Yes");
        if (account != null) {
            LOGGER.info("Account with account number: {}", account.getFormattedAccountNumber());
        }
        return account;
    }

    @Override
    public Transaction postCustomerPayment(DownPayment payment) {
        String decision = callCardDP("108", payment.getCustomerNumber(), payment.getAccountId(), payment.getCardNumber(), payment.getAmount(), "26");
        LOGGER.info("postCustomerPayment() called successfully -- decision: {}", decision);

        return new Transaction(decision, payment.getAmount());
    }

    @Transactional
    private String callCardDP(String clientId, String customerNumber, String accountId, String cardNumber, double amount, String tc) {
        StoredProcedureQuery spCardDP = entityManager.createStoredProcedureQuery("SP_CARDDP");
        spCardDP.registerStoredProcedureParameter("CLIENT", String.class, ParameterMode.IN).setParameter("CLIENT", clientId)
                .registerStoredProcedureParameter("CUST", String.class, ParameterMode.IN).setParameter("CUST", customerNumber)
                .registerStoredProcedureParameter("ACCT", String.class, ParameterMode.IN).setParameter("ACCT", accountId)
                .registerStoredProcedureParameter("SEQ", String.class, ParameterMode.IN).setParameter("SEQ", cardNumber)
                .registerStoredProcedureParameter("AMT", String.class, ParameterMode.IN).setParameter("AMT", Double.toString(amount))
                .registerStoredProcedureParameter("TC", String.class, ParameterMode.IN).setParameter("TC", tc)
                .registerStoredProcedureParameter("DECISION", String.class, ParameterMode.OUT)
                .execute();
        String decision = (String) spCardDP.getOutputParameterValue("DECISION");

        return decision;
    }
}
