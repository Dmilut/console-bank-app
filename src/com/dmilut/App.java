package com.dmilut;

import com.dmilut.controllers.AccountController;
import com.dmilut.entities.User;
import com.dmilut.utils.Initializer;
import com.dmilut.utils.Utils;
import com.dmilut.views.MainView;
import com.dmilut.views.UserView;

public class App {
    private static MainView mainView;
    private static UserView userView;
    private static AccountController accountController;
    private static User currentUser;

    public static void main(String[] args) {
        new Initializer().init();
        mainView = new MainView();
        userView = new UserView();

        mainView.printGreeting();
        mainView.printMainMenu();

        signInCycle();
        userCycle();
    }

    private static void signInCycle() {
        do {
            currentUser = mainView.signIn();

            if (currentUser == null) {
                System.out.println("Error!");
            }
        } while (currentUser == null);
    }

    private static void userCycle() {
        int userChoice;

        do {
            userView.printUserInfo(currentUser);
            userView.printUserAccountsMenu();
            userChoice = Utils.getUserChoice();

            if (userChoice != 0) {
                userAccountCycle(userChoice);
            }

        } while (userChoice != 0);
    }

    private static void userAccountCycle(long accountId) {
        int userChoice;

        userView.printUserAccountMenu();
        userChoice = Utils.getUserChoice();

        switch (userChoice) {
            case 1:
                userAccountTransactionHistoryCycle(accountId);
                break;
            case 2:
                withdrawCycle(accountId);
                break;
            case 3:
                depositCycle(accountId);
                break;
            case 4:
                transferCycle(accountId);
                break;
            case 0:
                //
                break;
            default:
                System.out.println("Error!");
        }

    }

    private static void userAccountTransactionHistoryCycle(long accountId) {
        int userChoice;

        do {
            userView.printAccountTransactionHistory(accountId);
            userChoice = Utils.getUserChoice();

            if (userChoice != 0) {
                System.out.println("Error!");
            }

        } while (userChoice != 0);
    }

    private static void withdrawCycle(long accountId) {
        userView.printWithdrawMenu(accountId);
        double amount = Utils.getUserInput();

        accountController = new AccountController();
        accountController.withdraw(accountId, amount);
    }

    private static void depositCycle(long accountId) {
        userView.printDepositMenu(accountId);
        double amount = Utils.getUserInput();

        accountController = new AccountController();
        accountController.deposit(accountId, amount);
    }

    private static void transferCycle(long accountIdFrom) {
        userView.printTransferMenu(currentUser.getId(), accountIdFrom);
        long accountIdTo = Utils.getUserChoice();
        userView.printSelectAmount();
        double amount = Utils.getUserInput();

        accountController = new AccountController();
        accountController.transfer(accountIdFrom, accountIdTo, amount);
    }

}

