package com.dmilut.entities;

import java.util.ArrayList;

public class Account {
    private AccountType type;
    private ArrayList<Transaction> transactions;

    public Account(AccountType type) {
        this.type = type;
        transactions = new ArrayList<>();
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
        for(Transaction transaction : transactions) {
            balance = balance + transaction.getAmount();
        }

        return balance;
    }
}