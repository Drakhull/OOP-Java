package com.ecommerce.models;

import com.ecommerce.utils.PasswordHashing;

import java.util.Scanner;

public abstract class User {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String password;

    public User (String name, String email, String password)
        throws Exception {

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

    public void simpleDisplay(){
        System.out.print("\nID: " + id +
                         "\nName: " + name);
    }

    public abstract void showMenu(User user, Scanner scanner) throws Exception;

    public boolean isPasswordValid(String passwordToValidate)
        throws Exception {

       return PasswordHashing.isPasswordValid(passwordToValidate, password);
    }

    public String getEmail(){
        return this.email;
    }
}
