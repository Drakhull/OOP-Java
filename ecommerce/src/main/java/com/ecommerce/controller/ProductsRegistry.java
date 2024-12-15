package com.ecommerce.controller;

import com.ecommerce.models.Product;

import java.util.HashMap;

public class ProductsRegistry {
     private static HashMap<Integer, Product> products = new HashMap<>();

     private ProductsRegistry(){
     }

    public static void put(Product product) {
        products.put(product.getId(), product);
    }

    public static Product get(Integer id) {
        return products.get(id);
    }

    public static boolean containsKey(Integer id) {
        return products.containsKey(id);
    }

    public static void displayProducts() {
        System.out.println("\n=============================================\n");
        products.forEach((id, product) -> {
            product.display();
            System.out.println("\n=============================================\n");
        });
    }
}
