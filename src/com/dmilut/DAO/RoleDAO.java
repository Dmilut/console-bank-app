package com.dmilut.DAO;

import com.dmilut.Storage;
import com.dmilut.entities.Role;
import com.dmilut.entities.User;

public class RoleDAO {

    public Role getRoleByUserId(long id) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                return user.getRole();
            }
        }

        return null;
    }
}