package com.americanfirstfinance.account.dao.persistence;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
