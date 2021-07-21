package com.dmilut.views;

import com.dmilut.controllers.AccountController;
import com.dmilut.controllers.TransactionController;
import com.dmilut.controllers.UserController;
import com.dmilut.entities.Account;
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
        System.out.println("Accounts");
        for (Account account : accountController.getByUserId(user.getId())) {
            System.out.println("Id = " + account.getId() + " type = " + account.getType() + " balance = " + account.getBalance());
        }
    }

    public void printUserAccountsMenu() {
        System.out.println("To select an account please enter account ID");
        System.out.println("  0) Quit");
    }

    public void printUserAccountMenu() {
        System.out.println("What would you like to do?");
        System.out.println("  1) Show account transaction history");
        System.out.println("  2) Withdraw");
        System.out.println("  3) Deposit");
        System.out.println("  4) Transfer");
        System.out.println("  0) Quit");
    }

    public void printAccountTransactionHistory(long accountId) {
        System.out.println("Account transaction history " + accountId);
        ArrayList<Transaction> transactions = transactionController.getTransactionsByAccountId(accountId);

        for (Transaction transaction : transactions) {
            System.out.println("Id = " + transaction.getId() + " ; amount = " + transaction.getAmount() +
                    " ; type = " + transaction.getType() + " ; timestamp = " + transaction.getTimestamp() +
                    " ; purpose = " + transaction.getPurpose());
        }

        System.out.println("  0) Quit");
    }

    public void printWithdrawMenu(long accountId) {
        System.out.println("Withdraw " + accountId);
    }

    public void printDepositMenu(long accountId) {
        System.out.println("Deposit " + accountId);
    }

    public void printTransferMenu(long userId, long accountId) {
        System.out.println("Transfer " + accountId);

        for (Account account : accountController.getByUserId(userId)) {
            System.out.println("Id = " + account.getId() + " type = " + account.getType() + " balance = " + account.getBalance());
        }

        System.out.println("To select the recipient's account, please enter an account ID");
        System.out.println("  0) Quit");
    }

    public void printSelectAmount() {
        System.out.println("Enter amount");
    }

}
