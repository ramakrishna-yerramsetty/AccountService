package com.americanfirstfinance.account.dao.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Account {

    @Id
    @SequenceGenerator(name = "accountSeq", sequenceName = "account_number_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "accountSeq")
    private String accountNumber;
    //I need to represent account status somehow -- funded, open, current, past due, collection, and closed -- what else?  And should it be derived?
    //If it's derived, I need to figure out how and/or what part of it is derived..  like I could store Open on the DB, and derive current / past due for display.
    @ManyToOne(fetch = FetchType.LAZY)
    private Dealer dealer;
    private int paymentDueDayOfMonth;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Customer> primaryAccountHolders;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Customer> cosigners;  //Join table, in this case, should have a flag indicating primary account holder or cosigner
    private double interestRate;
    private String currencyCode;
    private double balance;
    private double originalPrincipal;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactionHistory;

    @Transient
    public Transaction getLastPayment() {
        Transaction transaction = transactionHistory.stream().filter(txn -> TransactionType.PAYMENT == txn.getTransactionType()).reduce((first, second) -> second).orElse(null);

        return transaction;
    }
}
