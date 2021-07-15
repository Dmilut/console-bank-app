package com.dmilut.views;

import com.dmilut.controllers.AccountController;
import com.dmilut.controllers.TransactionController;
import com.dmilut.controllers.UserController;
import com.dmilut.entities.Account;
import com.dmilut.entities.AccountType;
import com.dmilut.entities.Transaction;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class UserView {
    private final UserController userController = new UserController();
    private final AccountController accountController = new AccountController();
    private final TransactionController transactionController = new TransactionController();

    public void printUserInfo(User user) {
        System.out.println("First name = " + user.getFirstName());
        System.out.println("Last name = " + user.getLastName());
        for (Account account : accountController.getAccountsByUserId(user.getId())) {
            System.out.println("Account type = " + account.getType() + " balance = " + account.getBalance());
        }
    }

    public void printUserAccountsMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Checking");
        System.out.println("2 - Saving");
        System.out.println("3 - Exit to User menu");
    }

    public void printUserAccountMenu() {
        System.out.println("What would you like to do?");
        System.out.println("  1) Show account transaction history");
        System.out.println("  2) Withdraw");
        System.out.println("  3) Deposit");
        System.out.println("  4) Transfer");
        System.out.println("  5) Quit");
    }

    public void printAccountTransactionHistory(User user, AccountType accountType) {
        System.out.println("Account transaction history" + accountType);
        ArrayList<Transaction> transactions = transactionController
                .getTransactionsByUserIdAndAccountType(user.getId(), accountType);
        for (Transaction transaction : transactions) {
            System.out.println("Id = " + transaction.getId() + " ; amount = " + transaction.getAmount() +
                    " ; type = " + transaction.getType() + " ; timestamp = " + transaction.getTimestamp() +
                    " ; purpose = " + transaction.getPurpose());
        }
    }

    public void printWithdrawMenu(AccountType accountType) {
        System.out.println("Withdraw" + accountType);
    }

    public void printDepositMenu(AccountType accountType) {
        System.out.println("Deposit" + accountType);
    }

    public void printTransferMenu(AccountType accountType) {
        System.out.println("Transfer" + accountType);
    }


}
