package com.example.manager;

import com.example.model.User;
import com.example.database.UserDatabase;

import java.util.List;

public class UserManager {
    private UserDatabase userDatabase;

    public UserManager() {
        this.userDatabase = new UserDatabase();
    }

    public void addUser (User user) {
        userDatabase.addUser (user);
    }

    public void removeUser (String email) {
        userDatabase.removeUser (email);
    }

    public List<User> listUsers() {
        return userDatabase.getAllUsers();
    }
}