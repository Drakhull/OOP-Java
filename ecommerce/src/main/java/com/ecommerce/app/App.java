package com.ecommerce.app;

import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Product;
import com.ecommerce.controller.UsersRegistry;
import com.ecommerce.controller.ProductsRegistry;

import java.util.Scanner;
import java.math.BigDecimal;

import com.ecommerce.ui.AuthUI;

import com.ecommerce.utils.SerializationUtils;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        UsersRegistry.displayUsers();
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        ProductsRegistry.displayProducts();
        System.out.println("Before deserialization");
        scanner.nextLine();

        SerializationUtils.deserializeData();

        UsersRegistry.displayUsers();
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        ProductsRegistry.displayProducts();
        System.out.println("After deserialization");
        scanner.nextLine();

        if (UsersRegistry.getUsers().isEmpty()) {
            Administrator admin = new Administrator("admin", "admin", "admin");
            UsersRegistry.put(admin);
            Customer cust = new Customer("cust", "cust", "cust", "cust");
            UsersRegistry.put(cust);
        }

        if (ProductsRegistry.getProducts().isEmpty()) {
            ProductsRegistry.put(new Product("Product 1", 10, "String description", "String category", new BigDecimal(20)));
        }


        try {
            while (true) {
                User user = AuthUI.menu(scanner);
                if (user == null) {
                    System.out.println("\n\nApplication Closed.\n\n");
                    scanner.nextLine();
                    break;
                }

                user.showMenu(user, scanner);
            }
        } finally {
            // Serializa os dados ao finalizar
            SerializationUtils.serializeData();
            scanner.close();
        }
    }
}
