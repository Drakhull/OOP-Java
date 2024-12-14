// package com.ecommerce.ui;
//
// import java.util.Scanner;
//
// public class CreateProductUI {
//     private CreateProductUI(){
//     }
//
//     public static void create()
//         throws Exception {
//
//         Product(String name, int quantityInStock, String description,
//                    String category, BigDecimal price);
//
//         Scanner scanner = new Scanner(System.in);
//
//         String name = "";
//         String quantityInStock = "";
//         String description = "";
//         String category = "";
//         String price = "";
//
//         ClearTerminal.clear();
//
//         System.out.println("Creating " + userType +"\nType 'exit' to leave\n");
//
//
//         while (true) {
//             System.out.println("\nName: ");
//             name = scanner.nextLine();
//             if (name.equalsIgnoreCase("exit"))
//                 return;
//         }
//
//         while (true) {
//             System.out.println("\nE-mail: ");
//             email = scanner.nextLine();
//             if (email.equalsIgnoreCase("exit"))
//                 return;
//         }
//     }
// }

package com.ecommerce.ui;

import com.ecommerce.models.Product;
import com.ecommerce.controller.ProductsRegistry;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductUI {
    private CreateProductUI() {
    }

    public static void create() throws Exception {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        int quantityInStock = 0;
        String description = "";
        String category = "";
        BigDecimal price = BigDecimal.ZERO;

        ClearTerminal.clear();

        System.out.println("Creating new Product\nType 'exit' to leave\n");

        while (true) {
            System.out.print("\nName: ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                return;
            }
            if (name.isEmpty()) {
                System.out.println("Product name cannot be empty. Please try again.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("\nQuantity in Stock: ");
            try {
                quantityInStock = Integer.parseInt(scanner.nextLine());
                if (quantityInStock < 0) {
                    System.out.println("Quantity must be a non-negative number. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        while (true) {
            System.out.print("\nDescription: ");
            description = scanner.nextLine();
            if (description.equalsIgnoreCase("exit")) {
                return;
            }
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. Please try again.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("\nCategory: ");
            category = scanner.nextLine();
            if (category.equalsIgnoreCase("exit")) {
                return;
            }
            if (category.isEmpty()) {
                System.out.println("Category cannot be empty. Please try again.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("\nPrice: ");
            try {
                price = new BigDecimal(scanner.nextLine());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Price must be a non-negative number. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number.");
            }
        }
        Product product = new Product(name, quantityInStock, description, category, price);
        ProductsRegistry.put(product);
        System.out.println("\nProduct created successfully!\n\n");
        product.display();

        System.out.println("\n===========================\n" +
                           "Press enter to continue...");
        scanner.nextLine();

    }
}

