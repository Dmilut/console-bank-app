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

    public static long getNewUserId() {
        ArrayList<User> users = getUsers();
        if (users.size() > 0) {
            return users.get(users.size() - 1).getId() + 1;
        }
        return 0;
    }

    public static long getNewTransactionId() {
        ArrayList<User> users = getUsers();
        long lastId = 0;
        for (User user : users) {
            for (Account account : user.getAccounts()) {
                for (Transaction transaction : account.getTransactions()) {
                    if (transaction.getId() > lastId) {
                        lastId = transaction.getId() + 1;
                    }
                }
            }
        }

        return lastId;
    }
}
