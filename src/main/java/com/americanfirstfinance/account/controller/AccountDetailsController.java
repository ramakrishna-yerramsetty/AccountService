package com.americanfirstfinance.account.controller;

import com.americanfirstfinance.account.handler.AccountDetailsHandler;
import com.americanfirstfinance.account.view.AccountDetailsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/poc/details")
public class AccountDetailsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsController.class);

    private final Validator validator;

    private final AccountDetailsHandler accountDetailsHandler;

    @Inject
    public AccountDetailsController(Validator validator, AccountDetailsHandler accountDetailsHandler) {
        this.validator = validator;
        this.accountDetailsHandler = accountDetailsHandler;
    }

    @GET
    @Path("/{customerNumber}/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountDetails(@PathParam("customerNumber") @NotNull @Pattern(regexp = "[0-9]{1,6}") @Valid String customerNumber,
                                      @PathParam("accountId") @NotNull @Pattern(regexp = "[0-9]{1,5}") @Valid String accountId) {
        LOGGER.info("getAccountDetails() -- customerNumber: {}  accountId: {}", customerNumber, accountId);
        AccountDetailsView view = accountDetailsHandler.getAccountDetails(customerNumber, accountId);

        if (view == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(view).build();
        }

    }
}
