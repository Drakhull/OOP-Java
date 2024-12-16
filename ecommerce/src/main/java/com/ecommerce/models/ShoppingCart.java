package com.ecommerce.models;

import java.math.BigDecimal;

public class ShoppingCart {
    private Customer customer;
    private Order order;

    public ShoppingCart(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public void addProductToCart(Product product, int quantity){
        order.addProduct(product, quantity);
    }

    public int getQuantityByProduct(Product product) {
        return order.getQuantity(product);
    }

    public void updateOrder(Order order, Product product, int quantity) {
        if (order.productAlreadyExistsInOrderProducts(product))
            this.order.incrementQuantity(product, quantity);
        else this.order = order;
    }

    public void display() {
        this.customer.simpleDisplay();
        System.out.println("\n==============================================");
        order.display();
    }

    public Order getOrder() {
        return this.order;
    }

    public BigDecimal getTotalValue() {
        return order.getTotalValue();
    }

    public boolean hasCustomer() {
        return customer != null;
    }
}
