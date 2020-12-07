package com.americanfirstfinance.account.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DownPayment {
    private String customerNumber = "";
    private String accountId = "";
    private String cardNumber = "";
    private double amount = 0.0;
}
