package com.ecommerce.models;

import java.util.ArrayList;

public class ShoppingCart {
    private Customer customer;
    private Order order;

    public ShoppingCart(Order order) {
        this.order = order;
    }

    public void display(){
            int purchaseCounter = 0;
        // for(Product product : products){
        //     System.out.println("Purchase Number " + purchaseCounter++);
        //     product.display();
        // }
    }

}
