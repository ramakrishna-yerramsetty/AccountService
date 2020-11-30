package com.americanfirstfinance.account.dao.persistence;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "customerSeq")
    private int customerId;

    private String firstName;
    private String lastName;
    @Embedded
    private Address address;  //But this isn't really an attribute, is it?

    //I could get a list of accounts here, but that's beyond the scope of what we're doing for POC.  But... if we're really trying to show off possibilities...
}
