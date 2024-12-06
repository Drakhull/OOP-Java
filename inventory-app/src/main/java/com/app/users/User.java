// Maven needed for InternetAddress
package com.app.users;

import com.app.security.PasswordHashing;


import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;


public class User {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String password;

//     protected or private?
    protected User() {

    }

    protected User (String name, String email, String password)
        throws Exception {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid E-mail: " + email);
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be 6 character lenght.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name field can't be blank.");
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

    public static boolean isEmailValid(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
