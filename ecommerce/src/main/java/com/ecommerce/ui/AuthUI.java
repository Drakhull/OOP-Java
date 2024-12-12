package com.ecommerce.ui;

import com.ecommerce.authentication.Auth;
import com.ecommerce.models.User;

import java.util.HashMap;

import java.util.Scanner;

public abstract class AuthUI {
    public static User authMenu(HashMap users)
        throws Exception {
            {
                ClearTerminal.clear();
                System.out.println("Welcome to the authentication menu!\nType 'exit' to leave.");

                String email = inputEmail(users);

                if (email.equalsIgnoreCase("exit") || inputPassword(users, email).equalsIgnoreCase("exit"))
                    return null;

                ClearTerminal.clear();
                System.out.println("Login successful\nWelcome!");

//                 should i return a "LoginResult" object containing the User instead?

                if (users.get(email) instanceof User)
                    return (User) users.get(email);
                return null;
            }
        }

        private static String inputEmail(HashMap users)
            throws Exception {

            Scanner scanner = new Scanner(System.in);
            String email = null;

            while (true){
                System.out.println("E-mail: ");
                email = scanner.next();

                if (email.equalsIgnoreCase("exit"))
                    return email;
                else if (!Auth.userEmailExists(users, email))
                         System.out.println("User does not exists or invalid e-mail.");
                    else return email;
            }
        }

        private static String inputPassword(HashMap users, String email)
            throws Exception {

            Scanner scanner = new Scanner(System.in);
            String password = null;

            while (true){
                System.out.println("Password: ");
                password = scanner.next();

                if (password.equalsIgnoreCase("exit"))
                    return password;
                else if (!Auth.userPasswordExists(users, email, password))
                        System.out.println("Invalid password.");
                    else return password;
            }
        }
}

