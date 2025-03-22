package com.example.database;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        this.users = new ArrayList<>();
    }

    public void addUser (User user) {
        users.add(user);
    }

    public void removeUser (String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }

    public List<User> getAllUsers() {
        return users;
    }
}