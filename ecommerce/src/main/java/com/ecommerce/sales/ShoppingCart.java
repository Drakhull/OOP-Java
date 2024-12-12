package com.ecommerce.sales;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;

    public ShoppingCart(ArrayList<Product> products){
    }

    public void display(){
            int purchaseCounter = 0;
        for(Product product : products){
            System.out.println("Purchase Number " + purchaseCounter++);
            product.display();
        }
    }

}
