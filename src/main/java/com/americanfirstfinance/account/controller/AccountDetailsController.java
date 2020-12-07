package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.handler.AccountDetailsHandler;
import com.americanfirstfinance.account.view.AccountDetailsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poc/details")
public class AccountDetailsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsController.class);

    private final AccountDetailsHandler accountDetailsHandler;

    @Inject
    public AccountDetailsController(AccountDetailsHandler accountDetailsHandler) {
        this.accountDetailsHandler = accountDetailsHandler;
    }

    @GET
    @Path("/{customerNumber}/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDetailsView getAccountDetails(@PathParam("customerNumber") String customerNumber, @PathParam("accountId") String accountId) {
        LOGGER.info("getAccountDetails() -- customerNumber: {}  accountId: {}", customerNumber, accountId);
        AccountDetailsView view = accountDetailsHandler.getAccountDetails(customerNumber, accountId);

        return view;

    }
}
