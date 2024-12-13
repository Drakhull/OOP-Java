package com.ecommerce.app;

import com.ecommerce.models.Customer;
import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import java.util.HashMap;

import com.ecommerce.ui.AuthUI;
import com.ecommerce.ui.LoginUI;

import com.ecommerce.authentication.Auth;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, User> users = new HashMap<>();

        Administrator admin = new Administrator("admin", "admin", "admin");
        users.put(admin.getEmail(), admin);

        Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        users.put(customer.getEmail(), customer);
        users.put("iuri1@gmail.com" ,new Customer("Iuri Vi ana", "iuri1@gmail.com", "password1234", "Anywhere1"));
        users.put("iuri2@gmail.com" ,new Customer("Iuri Vi a ana", "iuri2@gmail.com", "password1235", "Anywhere2"));
        users.put("iuri3@gmail.com" ,new Customer("Iuri 6 Grego", "iuri3@gmail.com", "password1236", "Anywhere3"));

        while (true){
            User user = AuthUI.menu(users);
            if (user == null){
                System.exit(0);
            } else if (user instanceof Customer) {
                    LoginUI.menuCustomer();
                } else if (user instanceof Administrator) {
                        LoginUI.menuAdmin();
                    }
        }

        // users.forEach((email, user_) -> {
        //     user.display();
        // });

    }
}
