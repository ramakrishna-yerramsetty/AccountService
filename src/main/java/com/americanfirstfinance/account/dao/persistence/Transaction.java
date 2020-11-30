package com.americanfirstfinance.account.dao.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.joda.money.Money;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@Entity
public class Transaction {

    @Id
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "transactionSeq")
    private int transactionId;


    private String confirmationNumber;
    private TransactionType transactionType;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    private String currencyCode;
    private double amount;
    private ZonedDateTime datePosted;
    private String notes;
    //TODO: -- Form of payment class to indicate how someone paid, but then that's only applicable to Payments -- now I want the Swift/Rust form of enums!

}
