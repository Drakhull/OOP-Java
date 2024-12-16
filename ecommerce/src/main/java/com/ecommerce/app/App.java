package com.ecommerce.app;

import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import com.ecommerce.controller.UsersRegistry;

import java.util.Scanner;

import com.ecommerce.ui.AuthUI;

import com.ecommerce.utils.SerializationUtils;

public class App {
    public static void main(String[] args) throws Exception {

        SerializationUtils.deserializeData();

        Scanner scanner = new Scanner(System.in);

        if (UsersRegistry.getUsers().isEmpty()) {
            Administrator admin = new Administrator("admin", "admin", "admin");
            UsersRegistry.put(admin);
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
            SerializationUtils.serializeData();
            scanner.close();
        }
    }
}
