package com.dmilut.services;

import com.dmilut.DAO.UserDAO;

public class AuthenticationService {
    public UserDAO userDAO = new UserDAO();

    public boolean isAuthenticate(String login, String password) {
        if (userDAO.getUserByLoginAndPassword(login, password) != null) {
            return true;
        }
        return false;
    }
}
