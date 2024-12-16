package com.ecommerce.controller;

import com.ecommerce.models.Product;

import java.util.HashMap;

import java.io.*;

public class ProductsRegistry implements Serializable {
     private static final long serialVersionUID = 3L;
     private static HashMap<Integer, Product> products = new HashMap<>();

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

    public static void displayInStockProducts() {
        System.out.println("\n=============================================\n");
        products.forEach((id, product) -> {
            product.displayInStock();
            System.out.println("\n=============================================\n");
        });
    }

    public static HashMap<Integer, Product> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<Integer, Product> newProducts) {
        products = newProducts;
    }

}
