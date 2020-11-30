package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.dao.persistence.Account;
import com.americanfirstfinance.account.handler.AccountDetailsHandler;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/poc/details")
public class AccountDetailsController {

    private final AccountDetailsHandler accountDetailsHandler;

    @Inject
    public AccountDetailsController(AccountDetailsHandler accountDetailsHandler) {
        this.accountDetailsHandler = accountDetailsHandler;
    }

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getControllerNameAsString() {
        return "AccountDetailsController";
    }*/

    //I might want to have a more account-focused view which doesn't disturb the lazy-initialized associations
    @GET
    @Path("/{accountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountDetails(@PathParam("accountNumber") String accountNumber) {
        return accountDetailsHandler.getAccountDetails(accountNumber);
    }
}
