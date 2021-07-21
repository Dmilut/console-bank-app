package com.dmilut.controllers;

import com.dmilut.DAO.AccountDAO;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.Transaction;
import com.dmilut.entities.TransactionType;

import java.util.ArrayList;

public class AccountController {
    private final AccountDAO accountDAO = new AccountDAO();

    public Account getAccountByUserIdAndType(long id, AccountType type) {
        return accountDAO.getAccountByUserIdAndType(id, type);
    }

    public ArrayList<Account> getAccountsByUserId(long id) {
        return accountDAO.getAccountsByUserId(id);
    }

    public void withdraw(long id, double amount, AccountType type) {
        getAccountByUserIdAndType(id, type).getTransactions().add(new Transaction(TransactionType.DEBIT, amount));

    }

    public void deposit(long id, double amount, AccountType type) {
        getAccountByUserIdAndType(id, type).getTransactions().add(new Transaction(TransactionType.CREDIT, amount));

    }
}
