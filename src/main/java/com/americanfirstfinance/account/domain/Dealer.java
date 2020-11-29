package com.americanfirstfinance.account.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Dealer {
    private String dealerId;
    private String name;
}
