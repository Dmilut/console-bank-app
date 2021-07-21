package com.dmilut.DAO;

import com.dmilut.Storage;
import com.dmilut.entities.Account;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class AccountDAO {

    public Account getById(long accountId) {
        for (Account account : getAccounts()) {
            if (account.getId() == accountId) {
                return account;
            }
        }

        return null;
    }

    public ArrayList<Account> getAccounts() {
        return Storage.getAccounts();
    }

    public ArrayList<Account> getAccountsByUserId(long userId) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == userId) {
                return user.getAccounts();
            }
        }

        return null;
    }
}
