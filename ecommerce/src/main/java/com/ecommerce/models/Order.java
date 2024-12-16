package com.ecommerce.models;

import com.ecommerce.utils.Reports;

import java.math.BigDecimal;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.*;

public class Order implements Serializable {
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(orderCounter);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        orderCounter = in.readInt();
    }

    public boolean isEmpty() {
        return orderProducts.isEmpty();
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = orderProducts.get(product);
        if (productAlreadyExists(product)) {
            orderProduct.incrementQuantity(quantity);
        } else {
            orderProducts.put(product, new OrderProduct(product, quantity));
        }

        Reports.compareAndChangeLowStockProduct (product);
        calculateTotalValue();
    }

    public int getQuantity(Product product) {
        OrderProduct orderProduct = orderProducts.get(product);
        return orderProduct.getQuantity();
    }

    public BigDecimal getTotalValue() {
        return this.totalValue;
    }

    public boolean productAlreadyExists(Product product) {
        OrderProduct orderProduct = orderProducts.get(product);

        return orderProduct != null;
    }

    public boolean productAlreadyExistsInOrderProducts(Product product) {
        OrderProduct orderProduct = orderProducts.get(product);
        Product foundProduct = orderProduct.getProduct();
        return foundProduct != null;
    }

    public void decrementStock () {
        orderProducts.forEach((id, orderProduct) -> {
            orderProduct.decrementStock(orderProduct.getQuantity());
            Reports.compareAndChangeLowStockProduct (orderProduct.getProduct());
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
        calculateTotalValue();
    }
    public void incrementQuantity(Product product, int quantity) {
        OrderProduct orderProduct = orderProducts.get(product);
        orderProduct.incrementQuantity(quantity);
        calculateTotalValue();
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
