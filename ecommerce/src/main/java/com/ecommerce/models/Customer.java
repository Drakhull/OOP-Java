package com.ecommerce.models;

import com.ecommerce.models.ShoppingCart;
import com.ecommerce.ui.LoginUI;

import java.util.Scanner;
import java.util.HashMap;

public class Customer extends User {
    private String address;
    private HashMap<Order, ShoppingCart> purchaseHistory;

    public Customer (String name, String email, String password, String address)
        throws Exception {
        super(name, email, password);

        this.address = address;
        this.purchaseHistory = new HashMap<Order, ShoppingCart>();
    }

    public void displayAllPurchases() {
        purchaseHistory.forEach((order, purchaseHistory) -> {
            order.display();
        });
    }

    public void display() {
        super.display();
        System.out.print("\nAddress: " + address +
                         "\n\nPurchase History: \n");
                          displayAllPurchases();
    }

    public void showMenu(User user, Scanner scanner)
        throws Exception {

        LoginUI.menuCustomer(user, scanner);
    }

    public void addPurchase(ShoppingCart purchase) {
        purchaseHistory.put(purchase.getOrder(), purchase);
    }
}
