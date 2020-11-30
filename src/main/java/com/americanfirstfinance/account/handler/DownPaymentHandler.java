package com.americanfirstfinance.account.handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.americanfirstfinance.account.form.CustomerPayment;
import com.americanfirstfinance.account.service.AccountService;
import com.americanfirstfinance.account.view.Receipt;

@ApplicationScoped
public class DownPaymentHandler {

    private final AccountService accountService;

    @Inject
    public DownPaymentHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public Receipt handleDownPayment(CustomerPayment payment) {
        return accountService.postDownPayment(payment);
    }

}
