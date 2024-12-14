package com.ecommerce.ui;

import java.util.Scanner;

public class CreateProductUI {
    private CreateProductUI(){
    }

    public static void menu()
        throws Exception {

        Scanner scanner = new Scanner(System.in);
        String option = "";


        while(!option.equalsIgnoreCase("0")) {
        ClearTerminal.clear();

        System.out.println("Welcome to the Create Product menu!\nType 'exit' to leave.\n");
        System.out.println("[0] Exit\n" +
                           "[1] Create New Product\n" +
                           "Choose an option: ");

            option = scanner.nextLine();

            switch (option){
                case "0": {
                    System.out.println("\n\nReturning...");
                    break;
                }

                case "1": {

                    break;
                }

                default:
                    System.out.println("\nInvalid Option.\n\nTry again: ");
            }
        }
    }
}
