package com.ecommerce.models;

import com.ecommerce.models.ShoppingCart;

import com.ecommerce.ui.LoginUI;

import java.util.ArrayList;

public class Customer extends User {
    private String address;
    private ArrayList<ShoppingCart> purchaseHistory;

    public Customer (String name, String email, String password, String address)
        throws Exception {
        super(name, email, password);

        this.address = address;
        this.purchaseHistory = new ArrayList<ShoppingCart>();
    }

    public void displayAllPurchases(){
        for(ShoppingCart purchase : purchaseHistory)
            purchase.display();
    }

    public void display(){
        super.display();
        System.out.print("\nAddress: " + address +
                         "\n\nPurchase History: \n");
                          displayAllPurchases();
    }

    public void showMenu(User user)
        throws Exception {

        LoginUI.menuCustomer(user);
    }
}
