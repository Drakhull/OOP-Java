package com.ecommerce.ui;

import com.ecommerce.models.User;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Administrator;

import java.util.Scanner;

public class LoginUI {
    private LoginUI(){
    }

    public static void menuAdmin(User user, Scanner scanner)
        throws Exception {

        boolean exit = false;
        while (!exit) {
            ClearTerminal.clear();

            if (user instanceof Administrator) {
                Administrator adm = (Administrator) user;


                System.out.println("Welcome Administrator!");
                System.out.println("\n[0] Exit" +
                                   "\n[1] Create New User" +
                                   "\n[2] Create New Product" +
                                   "\n[3] Reports" +
                                   "\n\nChoose an option: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "0": {
                        System.out.println("\n\nReturning...");
                        exit = true;
                        break;
                    }

                    case "1": {
                        adm.createNewUser(scanner);
                        break;
                    }

                    case "2": {
                        adm.createNewProduct(scanner);
                        break;
                    }

                    default:
                }
            }
            else {
                System.out.println("\nNot a valid Administrator.\n");
                break;
            }
        }
    }

    public static void menuCustomer(User user, Scanner scanner)
        throws Exception {

        boolean exit = false;

        while (!exit) {
            ClearTerminal.clear();

            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println("Welcome Customer!");
                System.out.println("\n[0] Exit" +
                                   "\n[1] Start new order" +
                                   "\n\nChoose an option: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "0": {
                        System.out.println("\n\nReturning...");
                        exit = true;
                        break;
                    }

                    case "1": {
                        ShoppingUI.menu(customer, scanner);
                        break;
                    }

                    default:
                }
            }
            else {
                System.out.println("\nNot a valid Customer.\n");
                break;
            }
        }
    }
}
