package com.americanfirstfinance.account.view;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

//This class is just a few fields of a summary view to return for the Account List endpoint
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class AccountSummaryView {
    private String accountNumber;
    private String dealerId;
    private String firstName;
    private String lastName;
    private String accountBalance;
    private String accountLine;
}
