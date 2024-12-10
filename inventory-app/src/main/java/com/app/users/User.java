package com.app.users;

import com.app.authentication.PasswordHashing;
import com.app.authentication.Validation;
import java.util.HashMap;

import java.util.ArrayList;



public abstract class User {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String password;

    public User (String name, String email, String password)
        throws Exception {
        if (!Validation.isUserValid(name, email, password)) {
            throw new IllegalArgumentException("Invalid user data.");
        }

        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.password = PasswordHashing.generateHash(password);
    }

    public void display(){
        System.out.print("\nID: " + id +
                         "\nName: " + name +
                         "\nE-Mail: " + email +
                         "\nPassword: " + password);
    }

    public boolean isPasswordValid(String passwordToValidate)
        throws Exception {

       return PasswordHashing.isPasswordValid(passwordToValidate, password);
    }

    public static void addUser(User user) {
        UsersHashMap.addUser(user, user.email);
        System.out.println("User" + user.name + "added");
    }

    public static User getUserByEmail() {
        return users.get(email);
    }
}
