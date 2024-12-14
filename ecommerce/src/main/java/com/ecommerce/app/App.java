package com.ecommerce.app;

import com.ecommerce.models.Customer;
import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import com.ecommerce.controller.UsersRegistry;
import java.util.HashMap;

import com.ecommerce.ui.AuthUI;
import com.ecommerce.ui.LoginUI;

import com.ecommerce.authentication.Auth;

public class App {
    public static void main(String[] args) throws Exception {
        // HashMap<String, User> users = new HashMap<>();

        Administrator admin = new Administrator("admin", "admin", "admin");
        UsersRegistry.put(admin);

        // Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        // UsersRegistry.put(customer);
        // UsersRegistry.put(new Customer("Iuri Vi ana", "iuri1@gmail.com", "password1234", "Anywhere1"));
        // UsersRegistry.put(new Customer("Iuri Vi a ana", "iuri2@gmail.com", "password1235", "Anywhere2"));
        // UsersRegistry.put(new Customer("Iuri 6 Grego", "iuri3@gmail.com", "password1236", "Anywhere3"));

        while (true) {
            User user = AuthUI.menu();
            if (user == null) {
                System.out.println("\n\nApplication Closed.\n\n");
                System.exit(0);
            }

            user.showMenu(user);

            // if (user instanceof Customer) {
            //         LoginUI.menuCustomer(user);
            //         break;
            // }
            //
            // if (user instanceof Administrator) {
            //         user(user);
            //         break;
            // }
            UsersRegistry.displayUsers();
        }
    }
}
