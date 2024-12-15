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
        System.out.println("\nProduct ID: " + id +
                           "\nName: " + name +
                           "\nQuantity in stock: " + quantityInStock +
                           "\nDescription: " + description +
                           "\nCategory: " + category +
                           "\nPrice: " + price);
    }

    public void displayInStock() {
        if (this.quantityInStock > 0)
            System.out.println("\nProduct ID: " + id +
                            "\nName: " + name +
                            "\nQuantity in stock: " + quantityInStock +
                            "\nDescription: " + description +
                            "\nCategory: " + category +
                            "\nPrice: " + price);
    }

        public void displayForOrder() {
        System.out.println("\nProduct ID: " + id +
                           "\nName: " + name +
                           "\nDescription: " + description +
                           "\nCategory: " + category +
                           "\nUnit Price: " + price);
    }

    public void incrementStockQuantity(int quantity) {
        this.quantityInStock += quantity;
    }

    public void decrementStockQuantity(int quantity) {
        if (this.quantityInStock > 0)
            this.quantityInStock -= quantity;
    }

    public boolean isStockEnough (int quantityOrdered) {
        return quantityInStock >= quantityOrdered;
    }

    public boolean isStockLesserThan (Product product) {
        return this.quantityInStock < product.getStock();
    }

    public int getId() {
        return this.id;
    }

    public int getStock() {
        return this.quantityInStock;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
