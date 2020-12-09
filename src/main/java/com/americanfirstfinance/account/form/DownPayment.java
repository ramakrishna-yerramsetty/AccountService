package com.americanfirstfinance.account.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class DownPayment {
    @NotNull
    @Size(min = 1, max = 9)
    @Pattern(regexp = "[0-9]+")
    private String customerNumber = "";
    @NotNull
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[0-9]+")
    private String accountId = "";
    @NotNull
    @Size(min = 1, max = 11)
    @Pattern(regexp = "[0-9]+")
    private String cardNumber = "";
    @NotNull
    //@Pattern(regexp = "[0-9]{1,8}+(.[0-9]{2})?")
    @DecimalMax(value = "99999999.99")
    private double amount = 0.0;
}
