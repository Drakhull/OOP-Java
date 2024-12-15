package com.ecommerce.app;

import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Product;
import com.ecommerce.controller.UsersRegistry;
import com.ecommerce.controller.ProductsRegistry;

import java.util.HashMap;
import java.util.Scanner;
import java.math.BigDecimal;

import com.ecommerce.ui.AuthUI;

public class App {
    public static void main(String[] args) throws Exception {
        Administrator admin = new Administrator("admin", "admin", "admin");
        UsersRegistry.put(admin);
        Customer cust = new Customer("cust", "cust", "cust", "cust");
        UsersRegistry.put(cust);

        ProductsRegistry.put(new Product("Product 1", 10, "String description", "String category", new BigDecimal(20)));
        ProductsRegistry.put(new Product("Product 2", 2, "String description", "String category", new BigDecimal(20)));
        ProductsRegistry.put(new Product("Product 3", 0, "String description", "String category", new BigDecimal(20)));
        ProductsRegistry.put(new Product("Product 4", 4, "String description", "String category", new BigDecimal(20)));
        ProductsRegistry.put(new Product("Product 5", 5, "String description", "String category", new BigDecimal(20)));
        ProductsRegistry.put(new Product("Product 6", 100, "String description", "String category", new BigDecimal(20)));

        // Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        // UsersRegistry.put(customer);
        // UsersRegistry.put(new Customer("Iuri Vi ana", "iuri1@gmail.com", "password1234", "Anywhere1"));
        // UsersRegistry.put(new Customer("Iuri Vi a ana", "iuri2@gmail.com", "password1235", "Anywhere2"));
        // UsersRegistry.put(new Customer("Iuri 6 Grego", "iuri3@gmail.com", "password1236", "Anywhere3"));

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                User user = AuthUI.menu(scanner);
                if (user == null) {
                    System.out.println("\n\nApplication Closed.\n\n");
                    break;
                }

                user.showMenu(user, scanner);
                UsersRegistry.displayUsers();
            }
        } finally {
            scanner.close();
        }
    }
}
