package com.app.app;

import com.app.users.Customer;
import com.app.users.User;
import com.app.users.UsersHashMap;

public class App
{
    public static void main(String[] args) throws Exception{
        Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "senha123", "Quinto dos infernos");
        User.addUser(customer);
        customer.display();
        System.out.println("\n------------------------------------------\n");
        customer.displayAllPurchases();
        System.out.println("\n\nsenha123: " + customer.isPasswordValid("senha123") +
                           "\ntaerrado: " + customer.isPasswordValid("taerrado"));
        System.out.println(User.UsersHashMap.getUserByEmail("iuri@gmail.com"));
    }
}
