package com.dmilut.entities;

import com.dmilut.Storage;

import java.util.ArrayList;

public class Account {
    private long id;
    private AccountType type;
    private ArrayList<Transaction> transactions;

    public Account(AccountType type) {
        id = Storage.getNewAccountId();
        this.type = type;
        transactions = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals(TransactionType.DEBIT)) {
                balance = balance - transaction.getAmount();
            } else {
                balance = balance + transaction.getAmount();
            }
        }

        return balance;
    }
}
