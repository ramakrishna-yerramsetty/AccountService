package com.americanfirstfinance.account.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Address {
    private String street1;
    private String street2;
    private String city;
    private State state;
    private String zip;
}
