package com.americanfirstfinance.account.dao.persistence;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Customer {

    private int customerId;

    private String firstName;
    private String lastName;
    private Address address;  //But this isn't really an attribute, is it?

    //I could get a list of accounts here, but that's beyond the scope of what we're doing for POC.  But... if we're really trying to show off possibilities...
}
