package com.ecommerce.ui;

import com.ecommerce.authentication.Auth;
import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;


import java.util.Scanner;

public class CreateUserUI {
    private CreateUserUI() {
    }

    public void menu()
        throws Exception {

        ClearTerminal.clear();
        System.out.println("Welcome to the Create User menu!\nType 'exit' to leave.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("[0] Exit\n" +
                           "[1] Create Administrator\n" +
                           "[2] Create Customer\n\n" +
                           "Choose an option: ");

        String option = scanner.next();

//         String email = inputEmail(users);
//
//         if (email.equalsIgnoreCase("exit") || inputPassword(users, email).equalsIgnoreCase("exit"))
//             return null;
//
//         ClearTerminal.clear();
//         System.out.println("Login successful\n");
//
// //      should i return a "LoginResult" object containing the User instead?
//
//         if (users.get(email) instanceof User)
//             return (User) users.get(email);
//         return null;

    }

    // private
}
