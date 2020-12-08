package com.americanfirstfinance.account.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.americanfirstfinance.account.form.DownPayment;
import com.americanfirstfinance.account.handler.DownPaymentHandler;
import com.americanfirstfinance.account.view.Receipt;

@Path("/poc/account/downpayment")
public class PostDownPaymentController {

    private final Validator validator;
    private final DownPaymentHandler downPaymentHandler;

    @Inject
    public PostDownPaymentController(Validator validator, DownPaymentHandler downPaymentHandler) {
        this.validator = validator;
        this.downPaymentHandler = downPaymentHandler;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt postDownPayment(@Valid DownPayment payment) {
        return downPaymentHandler.handleDownPayment(payment);
    }

}
