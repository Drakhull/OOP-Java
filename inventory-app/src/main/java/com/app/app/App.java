package com.app.app;

import com.app.users.Customer;
import com.app.users.User;
import com.app.users.UsersHashMap;

import com.app.ui.LoginUI;

import com.app.authentication.Login;

public class App
{
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        UsersHashMap.addUser(customer);
        UsersHashMap.addUser(new Customer("Iuri Vi ana", "iuri1@gmail.com", "password1234", "Anywhere1"));
        UsersHashMap.addUser(new Customer("Iuri Vi a ana", "iuri2@gmail.com", "password1235", "Anywhere2"));
        UsersHashMap.addUser(new Customer("Iuri 6 Grego", "iuri3@gmail.com", "password1236", "Anywhere3"));
        // UsersHashMap.displayAllUsers();

        LoginUI.loginMenu();

        Login.login("iuri@gmail.com", "password123");

        // if (UsersHashMap.getUserByEmail("iuri1@gmail.com") instanceof Customer){
        //     System.out.println("É uma instancia");
        // }else
        //     System.out.println("Não é uma instancia");
        // if (UsersHashMap.getUserByEmail("iuri@gmail.com") instanceof Customer){
        //     System.out.println("É uma instancia");
        // }else
        //     System.out.println("Não é uma instancia");
        // if (UsersHashMap.getUserByEmail("iuri@gmail.co") == null){
        //     System.out.println("É nulo");
        // }else System.out.println("Não nulo");
        // Customer customerGet = ((Customer)UsersHashMap.getUserByEmail("iuri@gmail.com"));
        // customerGet.display();
        // System.out.println("\n------------------------------------------\n");
        //
        // customer.display();
        // System.out.println("\n------------------------------------------\n");
        // customer.displayAllPurchases();
        // System.out.println("\n\npassword123: " + customer.isPasswordValid("password123") +
        //                    "\nit's Wrong: " + customer.isPasswordValid("it's Wrong"));
    }
}
