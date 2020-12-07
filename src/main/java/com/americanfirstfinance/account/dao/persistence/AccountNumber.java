package com.americanfirstfinance.account.dao.persistence;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class AccountNumber implements Serializable {
    @Column(name="MCUST")
    private int customerNumber;
    @Column(name="MACCT")
    private int accountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountNumber)) return false;
        AccountNumber that = (AccountNumber) o;
        return customerNumber == that.customerNumber &&
                accountId == that.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, accountId);
    }
}
