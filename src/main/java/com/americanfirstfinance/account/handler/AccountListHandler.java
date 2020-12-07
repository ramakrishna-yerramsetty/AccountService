package com.americanfirstfinance.account.handler;

import com.americanfirstfinance.account.view.AccountSummaryView;
import com.americanfirstfinance.account.service.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AccountListHandler {
    private final AccountService accountService;

    @Inject
    public AccountListHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<AccountSummaryView> handleAccountListRequest(String dealerId, int page) {
        //get what I need out of request parameters -- I don't think I need anything, though, except client ID and page once I implement JWT.
        //pass that client ID to the back end to get the list of Accounts
        //I don't need to post-process any of it, I don't think, but I really only need a summary view of the account -- And that's what I'll return
        List<AccountSummaryView> accountList = accountService.getAccountsForDealer(dealerId, page);

        return accountList;
    }

}
