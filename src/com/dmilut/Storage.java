package com.dmilut;

import com.dmilut.entities.Account;
import com.dmilut.entities.Transaction;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();

        for (User user : Storage.getUsers()) {
            if (!user.getAccounts().isEmpty()) {
                accounts.addAll(user.getAccounts());
            }
        }

        return accounts;
    }

    public static ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Account account : getAccounts()) {
            if (!account.getTransactions().isEmpty()) {
                transactions.addAll(account.getTransactions());
            }
        }

        return transactions;
    }

    public static long getNewUserId() {
        ArrayList<User> users = getUsers();
        if (users.size() > 0) {
            return users.get(users.size() - 1).getId() + 1;
        }

        return 1;
    }

    public static long getNewAccountId() {
        long lastId = 1;

        for (Account account : Storage.getAccounts()) {
            if (account.getId() >= lastId) {
                lastId = account.getId() + 1;
            }
        }


        return lastId;
    }

    public static long getNewTransactionId() {
        long lastId = 1;

        for (User user : getUsers()) {
            for (Account account : user.getAccounts()) {
                for (Transaction transaction : account.getTransactions()) {
                    if (transaction.getId() >= lastId) {
                        lastId = transaction.getId() + 1;
                    }
                }
            }
        }

        return lastId;
    }

}
