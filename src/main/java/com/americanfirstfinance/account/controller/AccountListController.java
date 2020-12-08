package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.view.AccountSummaryView;
import com.americanfirstfinance.account.handler.AccountListHandler;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/poc/accounts")
public class AccountListController {

    private final Validator validator;
    private final AccountListHandler accountListHandler;

    @Inject
    public AccountListController(Validator validator, AccountListHandler accountListHandler) {
        this.validator = validator;
        this.accountListHandler = accountListHandler;
    }

    @GET
    @Path("/{dealerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountSummaryView> getAccounts(@PathParam("dealerId") @NotNull @Valid String dealerId) {
        return accountListHandler.handleAccountListRequest(dealerId, 0);
    }

    @GET
    @Path("/{dealerId}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountSummaryView> getAccountsPaginated(@PathParam("dealerId") @NotNull @Valid String dealerId,
                                                         @PathParam("page") @NotNull @Max(value = 999) @Valid int page) {
        return accountListHandler.handleAccountListRequest(dealerId, page);
    }
}
