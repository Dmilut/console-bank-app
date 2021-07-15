package com.dmilut.controllers;

import com.dmilut.DAO.AccountDAO;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;

import java.util.ArrayList;

public class AccountController {
    private final AccountDAO accountDAO = new AccountDAO();

    public Account getAccountByUserIdAndType(long id, AccountType type) {
        return accountDAO.getAccountByUserIdAndType(id, type);
    }

    public ArrayList<Account> getAccountsByUserId(long id) {
        return accountDAO.getAccountsByUserId(id);
    }
}
