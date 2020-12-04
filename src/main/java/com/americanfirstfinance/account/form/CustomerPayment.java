package com.americanfirstfinance.account.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerPayment {
    private String accountNumber = "";
    private String currencyCode = "";
    private double amount = 0.0;
    private String cardType = "";
    private String cardNumber = "";
}
