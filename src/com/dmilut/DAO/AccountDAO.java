package com.dmilut.DAO;

import com.dmilut.Storage;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class AccountDAO {

    public Account getAccountByUserIdAndType(long id, AccountType type) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                for (Account account : user.getAccounts()) {
                    if (account.getType().equals(type)) {
                        return account;
                    }
                }
            }
        }

        return null;
    }

    public ArrayList<Account> getAccountsByUserId(long id) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                return user.getAccounts();
            }
        }

        return null;
    }
}
