package com.americanfirstfinance.account.dao.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "KWLBASE")
public class Account {
    @EmbeddedId
    private AccountNumber accountNumber;
    @Column(name="MFMTACCT")
    private String formattedAccountNumber;  //KWLBASE.MCUST + KWLBASE.MACCT, formatted is KWLBASE.MFMTACCT
    @Column(name="MDLR")
    private String dealerId;
    @Column(name="MDLRL")
    private String dealearLocation;
    @Column(name="MFNAME")
    private String firstName;
    @Column(name="MLNAME")
    private String lastName;
    @Column(name="MDUEDAY")
    private int paymentDueDayOfMonth = 0;
    //Customer info should be embeddable object
    @Column(name="MCBAL")
    private double balance;
    @Column(name="MPROCD")
    private double line;
    @Column(name="MTYPE")
    private String type;
    @Column(name="MPROD")
    private String product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return paymentDueDayOfMonth == account.paymentDueDayOfMonth &&
                Double.compare(account.balance, balance) == 0 &&
                Double.compare(account.line, line) == 0 &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(formattedAccountNumber, account.formattedAccountNumber) &&
                Objects.equals(dealerId, account.dealerId) &&
                Objects.equals(dealearLocation, account.dealearLocation) &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(type, account.type) &&
                Objects.equals(product, account.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, formattedAccountNumber, dealerId, dealearLocation, firstName, lastName, paymentDueDayOfMonth, balance, line, type, product);
    }
}
