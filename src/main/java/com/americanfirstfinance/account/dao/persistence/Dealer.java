package com.americanfirstfinance.account.dao.persistence;

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
public class Dealer {

    @Id
    @SequenceGenerator(name = "dealerSeq", sequenceName = "dealer_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "dealerSeq")
    private int dealerId;
    private String name;
}
