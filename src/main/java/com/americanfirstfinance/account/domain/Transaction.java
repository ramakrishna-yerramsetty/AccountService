package com.americanfirstfinance.account.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.joda.money.Money;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Transaction {
    private final int transactionId;
    private final String confirmationNumber;
    private final TransactionType transactionType;
    private final String description;
    private final Account account;
    private final Money amount;
    private final Customer madeBy;
    private final ZonedDateTime dateSubmitted;
    private final ZonedDateTime datePosted;
    private final String notes;
    //TODO: -- Form of payment class to indicate how someone paid, but then that's only applicable to Payments -- now I want the Swift/Rust form of enums!

}
