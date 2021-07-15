package com.dmilut.controllers;

import com.dmilut.DAO.TransactionDAO;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.Transaction;

import java.util.ArrayList;

public class TransactionController {
    private final TransactionDAO transactionDAO = new TransactionDAO();

    public ArrayList<Transaction> getTransactionsByUserIdAndAccountType(long id, AccountType type) {
        return transactionDAO.getTransactionsByUserIdAndAccountType(id, type);
    }
}
