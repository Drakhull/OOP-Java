package com.ecommerce.app;

import com.ecommerce.models.Customer;
import com.ecommerce.models.User;
import com.ecommerce.models.Administrator;
import java.util.HashMap;

import com.ecommerce.ui.AuthUI;

import com.ecommerce.authentication.Auth;

public class App
{
    public static void main(String[] args) throws Exception {
        HashMap<String, User> users = new HashMap<>();

        Administrator admin = new Administrator("admin", "admin", "admin");
        users.put(admin.getEmail(), admin);

        // Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        // users.put(customer.getEmail(), customer);
        // users.put("iuri1@gmail.com" ,new Customer("Iuri Vi ana", "iuri1@gmail.com", "password1234", "Anywhere1"));
        // users.put("iuri2@gmail.com" ,new Customer("Iuri Vi a ana", "iuri2@gmail.com", "password1235", "Anywhere2"));
        // users.put("iuri3@gmail.com" ,new Customer("Iuri 6 Grego", "iuri3@gmail.com", "password1236", "Anywhere3"));

        User user = AuthUI.authMenu(users);
        if (user instanceof Customer) {
            user.display();
        }
        if (user instanceof Administrator) {
            user.display();
        }
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
