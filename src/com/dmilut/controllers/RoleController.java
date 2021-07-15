package com.dmilut.controllers;

import com.dmilut.DAO.RoleDAO;
import com.dmilut.entities.Role;

public class RoleController {
    private final RoleDAO roleDAO = new RoleDAO();

    public Role getRoleById(long id) {
        return roleDAO.getRoleByUserId(id);
    }

}
