package com.ecommerce.ui;

import com.ecommerce.authentication.Validation;
import com.ecommerce.models.ShoppingCart;
import com.ecommerce.controller.ProductsRegistry;

// import com.ecommerce.models.;
// import com.ecommerce.models.;
// import com.ecommerce.models.;

import java.util.Scanner;

public class ShoppingUI {
    private ShoppingUI() {
    }

    public static void menu(Scanner scanner)
        throws Exception {

        boolean exit = false;

        while (!exit) {
            ClearTerminal.clear();

            // System.out.println("Welcome Customer!");
            System.out.println("\n[0] Exit" +
                               "\n[1] Add product" +
                               "\n[2] View shopping cart" +
                               "\n[3] Finish order" +
                               "\n\nChoose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0": {
                    System.out.println("\n\nReturning...");
                    exit = true;
                    break;
                }

                case "1": {
                    addProductMenu(scanner);
                    break;
                }

                case "2": {
                    ShoppingUI.menu(scanner);
                    break;
                }

                case "3": {
                    ShoppingUI.menu(scanner);
                    break;
                }

                default:
            }
        }
    }

    private static void addProductMenu(Scanner scanner) {
        int productId = -1;
        String input = null;

        while (true) {
            ClearTerminal.clear();
            ProductsRegistry.displayProducts();
            System.out.println("\nType 'exit' to leave.");
            try {
                System.out.println("\nInsert the product ID to add to your cart: ");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    productId = Integer.parseInt(input);
                    if (!ProductsRegistry.containsKey(productId)) {
                        System.out.println("Product ID not found. Please try again.");
                    } else {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
