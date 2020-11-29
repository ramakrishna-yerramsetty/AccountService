package com.americanfirstfinance.account.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Customer {
    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final Address address;

    //I could get a list of accounts here, but that's beyond the scope of what we're doing for POC.  But... if we're really trying to show off possibilities...
}
