package com.app.app;

import com.app.users.Customer;
import com.app.users.User;
import com.app.users.UsersHashMap;

public class App
{
    public static void main(String[] args) throws Exception{
        Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "password123", "Anywhere");
        UsersHashMap.addUser(customer);
        Customer customerGet = ((Customer)UsersHashMap.getUserByEmail("iuri@gmail.com"));
        customerGet.display();
        System.out.println("\n------------------------------------------\n");
        System.out.println("\n------------------------------------------\n");
        System.out.println("\n------------------------------------------\n");

        customerGet.display();
        System.out.println("\n------------------------------------------\n");
        customer.displayAllPurchases();
        System.out.println("\n\nsenha123: " + customer.isPasswordValid("password123") +
                           "\nit's Wrong: " + customer.isPasswordValid("it's Wrong"));
    }
}
