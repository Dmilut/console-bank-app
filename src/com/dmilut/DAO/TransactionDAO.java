package com.dmilut.DAO;

import com.dmilut.Storage;
import com.dmilut.entities.Account;
import com.dmilut.entities.Transaction;

import java.util.ArrayList;

public class TransactionDAO {
    private AccountDAO accountDAO;

    public ArrayList<Transaction> getTransactionsByAccountId(long accountId) {
        ArrayList<Account> accounts = Storage.getAccounts();

        for (Account account : accounts) {
            if (account.getId() == accountId) {
                return account.getTransactions();
            }
        }

        return null;
    }
}
