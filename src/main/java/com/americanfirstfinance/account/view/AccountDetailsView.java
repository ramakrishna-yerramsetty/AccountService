package com.americanfirstfinance.account.view;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AccountDetailsView {
    private final String accountNumber;
    private final String customerNumber;
    private final String accountId;
    private final String dealerId;
    private final String dealerLocation;
    private final String customerFirstName;
    private final String customerLastName;
    private final String dueDateOfMonth;
    private final String currentBalance;
    private final String creditLimit;
    private final String accountType;
    private final String accountProduct;
}
