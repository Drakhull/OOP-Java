package com.ecommerce.ui;

import com.ecommerce.utils.Validation;
import com.ecommerce.models.User;
import com.ecommerce.controller.UsersRegistry;

import java.util.Scanner;

public class AuthUI {
    private AuthUI(){
    }

    public static User menu(Scanner scanner)
        throws Exception {
        {
            ClearTerminal.clear();
            System.out.println("Welcome to the authentication menu!\nType 'exit' to leave.");

            String email = inputEmail(scanner);

            if (email.equalsIgnoreCase("exit") || inputPassword(email, scanner).equalsIgnoreCase("exit"))
                return null;

            ClearTerminal.clear();
            System.out.println("Login successful!\n");

//                 should i return a "LoginResult" object containing the User instead?

            if (UsersRegistry.get(email) instanceof User)
                return (User) UsersRegistry.get(email);
            return null;
        }
    }

    private static String inputEmail(Scanner scanner)
        throws Exception {

        String email = null;

        while (true){
            System.out.println("E-mail: ");
            email = scanner.next();

            if (email.equalsIgnoreCase("exit"))
                return email;
            else if (!UsersRegistry.containsKey(email))
                        System.out.println("User does not exists or invalid e-mail.");
                else return email;
        }
    }

    private static String inputPassword(String email, Scanner scanner)
        throws Exception {

        String password = null;

        while (true){
            System.out.println("Password: ");
            password = scanner.next();

            if (password.equalsIgnoreCase("exit"))
                return password;
            else if (!Validation.userPasswordExists(email, password))
                    System.out.println("Invalid password.");
                else return password;
        }
    }
}

