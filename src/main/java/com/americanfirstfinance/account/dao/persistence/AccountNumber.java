package com.americanfirstfinance.account.dao.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class AccountNumber implements Serializable {
    @Column(name="MCUST")
    private int customerNumber;
    @Column(name="MACCT")
    private int accountId;
}
