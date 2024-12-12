package com.app.ui;

import com.app.authentication.Login;
import com.app.users.UsersHashMap;
import com.app.users.User;

import java.util.Scanner;

public abstract class LoginUI {
    public static User loginMenu()
        throws Exception {
            {
                String email = inputEmail();

                if (email.equalsIgnoreCase("exit") || inputPassword(email).equalsIgnoreCase("exit"))
                    return null;

                System.out.println("Login successful\nWelcome!");

//                 should i return a "LoginResult" object containing the User instead?
                return UsersHashMap.getUserByEmail(email);
            }
        }

        private static String inputEmail()
            throws Exception {

            Scanner scanner = new Scanner(System.in);
            String email = null;

            while (true){
                System.out.println("E-mail: ");
                email = scanner.next();

                if (email.equalsIgnoreCase("exit"))
                    return email;
                else if (!Login.searchUserEmail(email))
                         System.out.println("User does not exists or invalid e-mail.");
                    else return email;
            }
        }

        private static String inputPassword(String email)
            throws Exception {

            Scanner scanner = new Scanner(System.in);
            String password = null;

            while (true){
                System.out.println("Password: ");
                password = scanner.next();

                if (password.equalsIgnoreCase("exit"))
                    return password;
                else if (!Login.searchUserPassword(email, password))
                        System.out.println("Invalid password.");
                    else return password;
            }
        }
}

