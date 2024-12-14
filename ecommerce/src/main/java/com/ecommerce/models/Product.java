package com.ecommerce.models;

import java.math.BigDecimal;

public class Product {
    private static int idCounter = 0;

    private int id;
    private int quantityInStock;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;

    public Product(String name, int quantityInStock, String description,
                   String category, BigDecimal price) {
        this.id = idCounter++;
        this.quantityInStock = quantityInStock;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public void display() {
        System.out.println("\nID: " + id + "\nName: " + name + "\nPrice: " +
                           "\nQuantity in stock: " + quantityInStock +
                           "\nDescription: " + description + "\nCategory: " + category);
    }
}
