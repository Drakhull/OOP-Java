package com.ecommerce.ui;

import com.ecommerce.models.User;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Administrator;
import com.ecommerce.utils.Reports;

import java.util.Scanner;

public class LoginUI {
    private LoginUI(){
    }

    public static void adminMenu(User user, Scanner scanner)
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

                    case "3": {
                        reportsMenu(scanner);
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

    public static void customerMenu(User user, Scanner scanner)
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

    private static void reportsMenu(Scanner scanner) {

        boolean exit = false;

        while (!exit) {
            ClearTerminal.clear();

            System.out.println("Reports Menu");
            System.out.println("\n[0] Exit" +
                                "\n[1] Most expensive order" +
                                "\n[2] Lowest stock product" +
                                "\n\nChoose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0": {
                    ClearTerminal.clear();
                    System.out.println("\n\nReturning...");
                    exit = true;
                    break;
                }

                case "1": {
                    ClearTerminal.clear();
                    Reports.displayHighestValuePurchase();
                    System.out.println("\n\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                }

                case "2": {
                    ClearTerminal.clear();
                    Reports.displaylowestStockProduct();
                    System.out.println("\n\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                }

                default:
            }
        }
    }

}

