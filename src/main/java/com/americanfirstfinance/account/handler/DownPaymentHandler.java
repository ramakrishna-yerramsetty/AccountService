package com.americanfirstfinance.account.handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.americanfirstfinance.account.form.DownPayment;
import com.americanfirstfinance.account.service.AccountService;
import com.americanfirstfinance.account.view.Receipt;

import java.util.UUID;

@ApplicationScoped
public class DownPaymentHandler {

    private final AccountService accountService;

    @Inject
    public DownPaymentHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public Receipt handleDownPayment(DownPayment payment) {
        //return new Receipt(UUID.randomUUID().toString(), "1-234567-1", "$100.00");
        return accountService.postDownPayment(payment);
    }

}
