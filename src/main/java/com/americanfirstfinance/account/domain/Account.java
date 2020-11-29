package com.americanfirstfinance.account.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.joda.money.Money;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Account {
    private final String accountNumber;
    //I need to represent account status somehow -- funded, open, current, past due, collection, and closed -- what else?  And should it be derived?
    //If it's derived, I need to figure out how and/or what part of it is derived..  like I could store Open on the DB, and derive current / past due for display.
    private final Dealer dealer;
    private int paymentDueDayOfMonth;
    private final List<Customer> primaryAccountHolders;
    private final List<Customer> cosigners;  //Join table, in this case, should have a flag indicating primary account holder or cosigner
    private final double interestRate;
    private final Money balance;
    private final Money originalPrincipal;
    private final List<Transaction> transactionHistory;

    public Transaction getLastPayment() {
        Transaction transaction = transactionHistory.stream().filter(txn -> TransactionType.PAYMENT == txn.getTransactionType()).reduce((first, second) -> second).orElse(null);

        return transaction;
    }
}
