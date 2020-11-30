package com.americanfirstfinance.account.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerPayment {
    private String accountNumber;
    private String currencyCode;
    private double amount;
    private String cardType;
    private String cardNumber;
}
