package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int orderCounter = 0;

    private int orderNumber;
    private LocalDateTime date;
    private HashMap<Product, OrderProduct> products;
    private BigDecimal totalValue;

    public Order (BigDecimal totalValue) {
        this.orderNumber = orderCounter++;
        this.date = LocalDateTime.now();
        this.products = new HashMap<>();
        this.totalValue = totalValue;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = products.get(product);
        if (orderProduct != null) {
            orderProduct.incrementQuantity(quantity);
        } else {
            products.put(product, new OrderProduct(product, quantity));
        }
    }

    public void display() {
        String formattedDate = this.date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        System.out.println("\n==============================================" +
                           "\nOrder Details" +
                           "\n==============================================" +
                           "\nOrder Number: " + orderNumber +
                           "\nDate: " + formattedDate +
                           "\n==============================================" +
                           "\nProducts in the Order:" +
                           "\n==============================================");

        if (products.isEmpty()) {
            System.out.println("No products in this order.");
        } else {
            for (OrderProduct orderProduct : products.values()) {
                Product product = orderProduct.getProduct();
                product.displayForOrder();
                System.out.println("Quantity: " + orderProduct.getQuantity() +
                                   "\nTotal: " + orderProduct.calculateValue() +
                                   "\n----------------------------------------------");
            }
        }
        System.out.println("==============================================" +
                           "\nTotal Order Value: " + totalValue +
                           "\n==============================================");
    }

    private class OrderProduct{
        private Product product;
        private int quantity;

        private OrderProduct(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        private void incrementQuantity(int quantity){
            this.quantity += quantity;
        }

        private void decrementQuantity(int quantity){
            if (this.quantity > 0)
                this.quantity -= quantity;
        }

        private BigDecimal calculateValue () {
            BigDecimal quantity = new BigDecimal(this.quantity);
            return quantity.multiply(product.getPrice());
        }

        private Product getProduct() {
            return this.product;
        }

        private int getQuantity() {
            return this.quantity;
        }
    }

    public BigDecimal calculateTotalValue() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderProduct orderProduct : products.values()) {
            total = total.add(orderProduct.calculateValue());
        }
        this.totalValue = total;
        return total;
    }
}
