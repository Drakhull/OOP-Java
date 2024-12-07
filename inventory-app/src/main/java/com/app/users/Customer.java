package com.app.users;

import com.app.sales.ShoppingCart;

import java.util.ArrayList;

public class Customer extends User {
    private String address;
    private ArrayList<ShoppingCart> purchaseHistory;

    public Customer (String name, String email, String password, String address)
        throws Exception {
        super(name, email, password);

        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address field can't be blank.");
        }

        this.address = address;
        this.purchaseHistory = new ArrayList<ShoppingCart>();
    }

        public void displayAllPurchases(){
        for(ShoppingCart purchase : purchaseHistory)
            purchase.display();
    }

    public void display(){
        super.display();
        System.out.print("\nAddress: " + address /*+
                           "\n\nPurchase History: \n" + displayAllPurchases()*/
                           );
    }
}
