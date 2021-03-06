package com.dmilut.controllers;

import com.dmilut.DAO.UserDAO;
import com.dmilut.entities.User;

import java.util.ArrayList;

public class UserController {
    private final UserDAO userDAO = new UserDAO();

    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userDAO.getUserByLoginAndPassword(login, password);
    }

    public ArrayList<User> getUsers() {
        return userDAO.getUsers();
    }

    public void create(String firstName, String lastName) {
        userDAO.add(new User(firstName, lastName));
    }

    public void delete(long id) {
        userDAO.delete(id);
    }
}
