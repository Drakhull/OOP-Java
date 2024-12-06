package com.app.app;

import com.app.users.Customer;

public class App 
{
    public static void main(String[] args) throws Exception{
        Customer customer = new Customer("Iuri Viana", "iuri@gmail.com", "senha123", "Quinto dos infernos");
        customer.display();
        System.out.println("\n\nsenha123: " + customer.isPasswordValid("senha123") +
                           "\ntaerrado: " + customer.isPasswordValid("taerrado"));
    }
}
