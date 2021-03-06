package com.dmilut.views;

import com.dmilut.controllers.MainController;
import com.dmilut.controllers.UserController;
import com.dmilut.entities.User;
import com.dmilut.utils.Utils;

public class MainView {
    private final MainController mainController = new MainController();
    private final UserController userController = new UserController();

    public void printGreeting() {
        System.out.println("Hello!");
    }

    public void printMainMenu() {
        System.out.println("1 - Sign In");
        System.out.println("2 - Exit");
    }

    public User signIn() {
        String login;
        String password;

        System.out.println("Please enter your login");
        login = Utils.scanner.nextLine();
        System.out.println("Please enter your password");
        password = Utils.scanner.nextLine();

        if (mainController.isAuthenticate(login, password)) {
            return userController.getUserByLoginAndPassword(login, password);
        }

        return null;
    }
}
