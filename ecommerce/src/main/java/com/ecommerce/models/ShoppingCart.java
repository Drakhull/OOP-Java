package com.ecommerce.models;

public class ShoppingCart {
    private Customer customer;
    private Order order;

    public ShoppingCart(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public void display(){
        this.customer.simpleDisplay();
        System.out.println("\n==============================================");
        order.display();
    }

    public Order getOrder(){
        return this.order;
    }
}
