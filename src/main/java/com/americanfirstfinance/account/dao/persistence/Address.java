package com.americanfirstfinance.account.dao.persistence;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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
