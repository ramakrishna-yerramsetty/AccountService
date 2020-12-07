package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.handler.AccountDetailsHandler;
import com.americanfirstfinance.account.view.AccountDetailsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/poc/details")
public class AccountDetailsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsController.class);

    private final AccountDetailsHandler accountDetailsHandler;

    @Inject
    public AccountDetailsController(AccountDetailsHandler accountDetailsHandler) {
        this.accountDetailsHandler = accountDetailsHandler;
    }

    //I might want to have a more account-focused view which doesn't disturb the lazy-initialized associations
    @GET
    @Path("/{customerNumber}/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDetailsView getAccountDetails(@PathParam("customerNumber") String customerNumber, @PathParam("accountId") String accountId) {
        LOGGER.info("getAccountDetails() -- customerNumber: {}  accountId: {}", customerNumber, accountId);
        return accountDetailsHandler.getAccountDetails(customerNumber, accountId);

    }
}
