package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int orderCounter = 0;

    private int orderNumber;
    private LocalDateTime date;
    private HashMap<Product, OrderProduct> orderProducts;
    private BigDecimal totalValue;

    public Order () {
        this.orderNumber = orderCounter++;
        this.date = LocalDateTime.now();
        this.orderProducts = new HashMap<>();
        this.totalValue = BigDecimal.ZERO;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = orderProducts.get(product);
        if (productAlreadyExists(product)) {
            orderProduct.incrementQuantity(quantity);
        } else {
            orderProducts.put(product, new OrderProduct(product, quantity));
        }

        calculateTotalValue();
    }

    public int getQuantity(Product product) {
        OrderProduct orderProduct = orderProducts.get(product);
        return orderProduct.getQuantity();
    }

    public boolean productAlreadyExists(Product product) {
        OrderProduct orderProduct = orderProducts.get(product);

        return orderProduct != null;
    }

    // public void validateOrRemoveProduct(Product product, int quantity) {
    //     OrderProduct orderProduct = orderProducts.get(product);
    //     if (orderProduct != null) {
    //
    //         orderProduct.decrementQuantity(quantity);
    //
    //         if (orderProduct.getQuantity() <= 0) {
    //             orderProducts.remove(product);
    //         }
    //
    //         calculateTotalValue();
    //     } else {
    //         System.out.println("Product not found in the order.");
    //     }
    // }

    public void decrementStock () {
        orderProducts.forEach((id, product) -> {
            product.decrementStock(product.getQuantity());
        });
    }
    public void incrementStock () {
        orderProducts.forEach((id, product) -> {
            product.incrementStock(product.getQuantity());
        });
    }

    public void decrementQuantity(Product product, int quantity) {
        OrderProduct orderProduct = orderProducts.get(product);
        orderProduct.decrementQuantity(quantity);
    }
    public void incrementQuantity(Product product, int quantity) {
        OrderProduct orderProduct = orderProducts.get(product);
        orderProduct.incrementQuantity(quantity);
    }

    // public boolean isStockEnough(Product product, int quantity) {
    //
    //     OrderProduct orderProduct = orderProducts.get(product);
    //     return orderProduct.isStockEnough(product, quantity);
    // }

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

        if (orderProducts.isEmpty()) {
            System.out.println("No products in this order.");
        } else {
            for (OrderProduct orderProduct : orderProducts.values()) {
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
        private int quantity = 0;

        private OrderProduct(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        private void incrementQuantity(int quantity){
            this.quantity += quantity;
        }

        private void decrementStock(int quantity) {
            this.product.decrementStockQuantity(quantity);
        }

        private void decrementQuantity(int quantity) {
            if (this.quantity > 0)
                this.quantity -= quantity;
        }

        private void incrementStock(int quantity) {
            this.product.decrementStockQuantity(quantity);
        }

        private BigDecimal calculateValue () {
            BigDecimal quantity = new BigDecimal(this.quantity);
            return quantity.multiply(product.getPrice());
        }

        // private boolean isStockEnough(Product product, int quantity) {
        //     return product.isStockEnough((this.quantity + quantity));
        // }

        private Product getProduct() {
            return this.product;
        }

        private int getQuantity() {
            return this.quantity;
        }
    }

    public void calculateTotalValue() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderProduct orderProduct : orderProducts.values()) {
            total = total.add(orderProduct.calculateValue());
        }
        this.totalValue = total;
        // return total;
    }
}
