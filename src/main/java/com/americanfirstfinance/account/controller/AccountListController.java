package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.view.AccountSummaryView;
import com.americanfirstfinance.account.handler.AccountListHandler;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/poc/accounts")
public class AccountListController {

    private final AccountListHandler accountListHandler;

    @Inject
    public AccountListController(AccountListHandler accountListHandler) {
        this.accountListHandler = accountListHandler;
    }

    @GET
    @Path("/{dealerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountSummaryView> getAccounts(@PathParam("dealerId") String dealerId) {
        return accountListHandler.handleAccountListRequest(dealerId, 0);
    }

    @GET
    @Path("/{dealerId}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountSummaryView> getAccountsPaginated(@PathParam("dealerId") String dealerId, @PathParam("page") int page) {
        return accountListHandler.handleAccountListRequest(dealerId, page);
    }
}
