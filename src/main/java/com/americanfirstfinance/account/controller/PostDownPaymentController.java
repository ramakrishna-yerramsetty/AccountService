package com.americanfirstfinance.account.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.americanfirstfinance.account.form.CustomerPayment;
import com.americanfirstfinance.account.handler.DownPaymentHandler;
import com.americanfirstfinance.account.view.Receipt;

@Path("/poc/account/downpayment")
public class PostDownPaymentController {

    private final DownPaymentHandler downPaymentHandler;

    @Inject
    public PostDownPaymentController(DownPaymentHandler downPaymentHandler) {
        this.downPaymentHandler = downPaymentHandler;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt postDownPayment(CustomerPayment payment) {
        return downPaymentHandler.handleDownPayment(payment);
    }

}
