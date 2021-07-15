package com.dmilut.DAO;

import com.dmilut.Storage;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.Transaction;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class TransactionDAO {

    public ArrayList<Transaction> getTransactionsByUserIdAndAccountType(long id, AccountType type) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                for (Account account : user.getAccounts()) {
                    if (account.getType().equals(type)) {
                        return account.getTransactions();
                    }
                }
            }
        }

        return null;
    }
}
