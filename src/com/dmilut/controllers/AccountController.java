package com.dmilut.controllers;

import com.dmilut.DAO.AccountDAO;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.Transaction;
import com.dmilut.entities.TransactionType;

import java.util.ArrayList;

public class AccountController {
    private final AccountDAO accountDAO = new AccountDAO();

    public Account getById(long accountId) {
        return accountDAO.getById(accountId);
    }

    public ArrayList<Account> getByUserId(long userId) {
        return accountDAO.getAccountsByUserId(userId);
    }

    public void withdraw(long accountId, double amount) {
        getById(accountId).getTransactions().add(new Transaction(TransactionType.DEBIT, amount));

    }

    public void deposit(long accountId, double amount) {
        getById(accountId).getTransactions().add(new Transaction(TransactionType.CREDIT, amount));

    }

    public void transfer(long accountIdFrom, long accountIdTo, double amount) {
        getById(accountIdFrom).getTransactions().add(new Transaction(TransactionType.DEBIT, amount));
        getById(accountIdTo).getTransactions().add(new Transaction(TransactionType.CREDIT, amount));
    }
}
