package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Order {
    private static int orderCounter = 0;

    private int orderNumber;
    private String date;
    private TreeMap<Product, OrderProduct> products;
    private BigDecimal totalValue;

    public Order (String date, BigDecimal totalValue) {
        this.orderNumber = orderCounter++;
        this.date = date;
        this.products = new TreeMap<>();
        this.totalValue = totalValue;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = products.get(product);
        if (orderProduct != null) {
            // orderProduct.setQuantity(orderProduct.getQuantity() + quantity);
        } else {
            products.put(product, new OrderProduct(product, quantity));
        }
    }

    private class OrderProduct {
        private Product product;
        private int quantity;

        private OrderProduct(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }
}
