package com.dmilut.utils;

import com.dmilut.Storage;
import com.dmilut.entities.*;

public class Initializer {

    public void init() {
        User user = new User("John", "Wick");
        user.setLogin("test");
        user.setPassword("123");
        Storage.getUsers().add(user);

        Account checkingAccount = new Account(AccountType.CHECKING);
        checkingAccount.getTransactions().add(new Transaction(TransactionType.CREDIT, 300.50));
        user.getAccounts().add(checkingAccount);

        Account savingAccount = new Account(AccountType.SAVING);
        savingAccount.getTransactions().add(new Transaction(TransactionType.DEBIT, 50.25));
        user.getAccounts().add(savingAccount);


    }
}
