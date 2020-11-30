package com.americanfirstfinance.account.view;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.joda.money.Money;

import java.time.ZonedDateTime;
import java.util.List;

//This class is just a few fields of a summary view to return for the Account List endpoint
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class AccountSummary {
    private String accountNumber;
    private String dealerName;
    private List<String> primaryAccountHolders;
    private List<String> coSigners;
    private Money accountBalance;
    private Money lastPaymentAmount;
    private ZonedDateTime lastPaymentDate;
}
