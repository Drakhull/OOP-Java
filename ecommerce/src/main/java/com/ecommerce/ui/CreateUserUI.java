package com.ecommerce.ui;

import com.ecommerce.utils.Validation;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Administrator;
import com.ecommerce.controller.UsersRegistry;

import java.util.Scanner;

// this class is far from perfect, but i don't have much time left to improve it, so sorry
public class CreateUserUI {
    private CreateUserUI() {
    }

    public static void menu(Scanner scanner)
        throws Exception {

        String option = "";


        while(!option.equalsIgnoreCase("0")) {
            ClearTerminal.clear();

            System.out.println("Welcome to the User Creation menu!\n");
            System.out.println("[0] Exit\n" +
                               "[1] Create Administrator\n" +
                               "[2] Create Customer\n\n" +
                               "Choose an option: ");

            option = scanner.nextLine();

            switch (option){
                case "0": {
                    System.out.println("\n\nReturning...");
                    break;
                }

                case "1": {
                    createUser("Administrator", scanner);
                    break;
                }

                case "2": {
                    createUser("Customer", scanner);
                    break;
                }

                default:
            }
        }
    }

    private static void createUser(String userType, Scanner scanner)
        throws Exception {

        ClearTerminal.clear();

        String name = "";
        String email = "";
        String password = " ";
        String passwordConfirmation = "";

        System.out.println("Creating " + userType +"\nType 'exit' to leave\n");


        while (true) {
            System.out.println("\nName: ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit"))
                return;
            if (Validation.isNameValid(name))
                break;

            System.out.println("\n\nName can't be empty or contain special characters!"+
                               "\n\nTry again: ");
        }

        while (true) {
            System.out.println("\nE-mail: ");
            email = scanner.nextLine();
            if (email.equalsIgnoreCase("exit"))
                return;
            if (Validation.isEmailValid(email) && !UsersRegistry.containsKey(email))
                break;

            System.out.println("\n\nInvalid E-mail or wrong format! Example: 'user.name@example.com'" +
                                "\n\nTry again: ");
        }

        while (!passwordConfirmation.equals(password) &&
               (password.equals(" ") && passwordConfirmation.equals(""))) {
            while (!Validation.isPasswordStrong(password)) {
                System.out.println("\nPassword: ");
                password = scanner.nextLine();
                if (password.equalsIgnoreCase("exit"))
                    return;
                if (!Validation.isPasswordStrong(password))
                     System.out.println("\nPassword has to be:" +
                                        "\n- Not empty" +
                                        "\n- 8 characters long" +
                                        "\n- At least 1 lowercase letter" +
                                        "\n- At least 1 uppercase letter" +
                                        "\n- At least 1 digit" +
                                        "\n- At least 1 special character" +
                                        "\n\nTry again: ");
            }

            System.out.println("\nConfirm password: ");
            passwordConfirmation = scanner.nextLine();
            if (passwordConfirmation.equalsIgnoreCase("exit"))
                return;
            if (!passwordConfirmation.equals(password)) {
                System.out.println("\nPassword Mismatch." +
                                    "\n\nTry again:");
            }
        }

        if (userType.equals("Customer")) {
            String address = "";
            System.out.println("\nAddress: ");
            while (true) {
                address = scanner.nextLine();
                if (!address.isEmpty())
                    break;
                System.out.println("\nAddress can't be empty!" +
                                   "\n\nTry again: ");
            }
            UsersRegistry.put(new Customer(name, email, password, address));
        } else if (userType.equals("Administrator")){
                    UsersRegistry.put(new Administrator(name, email, password));
                }
    }
}

