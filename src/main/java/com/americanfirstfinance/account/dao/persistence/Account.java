package com.americanfirstfinance.account.dao.persistence;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "KWLBASE")
public class Account {

    @Id
    @Column(name="MFMTACCT")
    private String accountNumber;  //KWLBASE.MCUST + KWLBASE.MACCT, formatted is KWLBASE.MFMTACCT
    @Column(name="MDLR")
    private String dealerId;  //I think dealer ID is MDLR -- which table has dealer info?
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
    //MTYPE -- these two columns define what kind of loan this is
    //MPROD
}
