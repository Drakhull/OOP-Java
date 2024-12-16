package com.ecommerce.utils;

import com.ecommerce.models.ShoppingCart;
import com.ecommerce.models.Product;
import com.ecommerce.models.Order;

import java.math.BigDecimal;

import java.io.*;

public class Reports implements Serializable {
    private static final long serialVersionUID = 15L;
    private static ShoppingCart highestValuePurchase = null;
    private static Product lowestStockProduct = null;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(highestValuePurchase);
        out.writeObject(lowestStockProduct);
    }

    // Método de desserialização personalizado
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        highestValuePurchase = (ShoppingCart) in.readObject();
        lowestStockProduct = (Product) in.readObject();
    }

    public static void compareAndChangePurchase (ShoppingCart purchase) {
        if (highestValuePurchase == null) {
            highestValuePurchase = purchase;
        }
        else if (purchase != null &&
                purchase.getTotalValue().compareTo(highestValuePurchase.getTotalValue()) > 0) {
                 highestValuePurchase = purchase;
        }
    }

    public static void displayHighestValuePurchase () {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("|+++++++++++++++++Highest Value Purchase++++++++++++++++++|\n");
        System.out.println("-----------------------------------------------------------\n");
        if (highestValuePurchase != null){
            highestValuePurchase.display();
        }else System.out.println("------------------It's Empty------------------");
    }

    public static void compareAndChangeLowStockProduct (Product product) {
        if (lowestStockProduct == null){
            lowestStockProduct = product;
        }
        else if (product != null && product.isStockLesserThan (lowestStockProduct)) {
                lowestStockProduct = product;
            }
    }

    public static void displaylowestStockProduct () {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("|++++++++++++++++++Lowest Stock Product+++++++++++++++++++|\n");
        System.out.println("-----------------------------------------------------------\n");
        if (highestValuePurchase != null){
            lowestStockProduct.display();
        }else System.out.println("------------------It's Empty------------------");
    }

        public static ShoppingCart getHighestValuePurchase() {
        return highestValuePurchase;
    }

    public static void setHighestValuePurchase(ShoppingCart purchase) {
        highestValuePurchase = purchase;
    }

    public static Product getLowestStockProduct() {
        return lowestStockProduct;
    }

    public static void setLowestStockProduct(Product product) {
        lowestStockProduct = product;
    }
}
