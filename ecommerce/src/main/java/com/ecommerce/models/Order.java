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











// package com.ecommerce.models;
//
// import java.math.BigDecimal;
// import java.util.TreeMap;
//
// public class Order {
//     private static int orderCounter = 0;
//
//     private int orderNumber;
//     private String date;
//     private TreeMap<Product, OrderProduct> products;  // Usando Product como chave
//     private BigDecimal totalValue;
//
//     public Order(String date, BigDecimal totalValue) {
//         this.orderNumber = ++orderCounter;  // Aumenta o contador de pedido
//         this.date = date;
//         this.products = new TreeMap<>();  // TreeMap, ordenando por produto
//         this.totalValue = totalValue;
//     }
//
//     public void addProduct(Product product, int quantity) {
//         // Verifica se o produto já existe no mapa, e soma a quantidade
//         OrderProduct orderProduct = products.get(product);
//         if (orderProduct != null) {
//             // Atualiza a quantidade se o produto já existe
//             orderProduct.setQuantity(orderProduct.getQuantity() + quantity);
//         } else {
//             // Se não existir, adiciona o produto com a quantidade
//             products.put(product, new OrderProduct(product, quantity));
//         }
//     }
//
//     private class OrderProduct {
//         private Product product;
//         private int quantity;
//
//         public OrderProduct(Product product, int quantity) {
//             this.product = product;
//             this.quantity = quantity;
//         }
//
//         public int getQuantity() {
//             return quantity;
//         }
//
//         public void setQuantity(int quantity) {
//             this.quantity = quantity;
//         }
//
//         public Product getProduct() {
//             return product;
//         }
//     }
//
//     // Método para calcular o total da ordem baseado nos produtos e suas quantidades
//     public void calculateTotalValue() {
//         BigDecimal total = BigDecimal.ZERO;
//         for (OrderProduct orderProduct : products.values()) {
//             BigDecimal productPrice = orderProduct.getProduct().getPrice(); // Considerando que Product tem um método getPrice()
//             total = total.add(productPrice.multiply(BigDecimal.valueOf(orderProduct.getQuantity())));
//         }
//         this.totalValue = total;
//     }
//
//     public BigDecimal getTotalValue() {
//         return totalValue;
//     }
//
//     public int getOrderNumber() {
//         return orderNumber;
//     }
//
//     public String getDate() {
//         return date;
//     }
//
//     public TreeMap<Product, OrderProduct> getProducts() {
//         return products;
//     }
// }

