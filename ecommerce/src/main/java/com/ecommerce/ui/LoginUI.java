package com.ecommerce.ui;

import java.util.Scanner;

public class LoginUI {
    private LoginUI(){
    }

    public static void menuAdmin(){
        System.out.println("\nWelcome Administrator!");
        System.out.println("\n[0] Exit" +
                           "\n[1] Create Administrator" +
                           "\n[2] Create Customer" +
                           "\n[3] Create New Product" +
                           "\n[4] Reports" +
                           "\n\nChoose an option: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

    }

    public static void menuCustomer(){
        System.out.println("Welcome Customer!");
    }
}
