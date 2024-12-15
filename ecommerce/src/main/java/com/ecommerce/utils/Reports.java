package com.ecommerce.utils;

import com.ecommerce.models.ShoppingCart;
import com.ecommerce.models.Product;
import com.ecommerce.models.Order;

import java.math.BigDecimal;

public class Reports {
    private static ShoppingCart highestValuePurchase = new ShoppingCart(null, new Order());
    private static Product lowestStockProduct = new Product("Product 1", Integer.MAX_VALUE, "String description", "String category", new BigDecimal(20));

    public static void compareAndChangePurchase (ShoppingCart purchase) {
        if (purchase == null) {
            highestValuePurchase = purchase;
        }
        else if (purchase.getTotalValue().compareTo(highestValuePurchase.getTotalValue()) > 0) {
                 highestValuePurchase = purchase;
        }
    }

    public static void displayHighestValuePurchase () {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("|+++++++++++++++++Highest Value Purchase++++++++++++++++++|\n");
        System.out.println("-----------------------------------------------------------\n");
        highestValuePurchase.display();
    }

    public static void compareAndChangeLowStockProduct (Product product) {
        if (product == null){
            lowestStockProduct = product;
        }
        else if (product.isStockLesserThan (lowestStockProduct)) {
                lowestStockProduct = product;
            }
    }

    public static void displaylowestStockProduct () {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("|++++++++++++++++++Lowest Stock Product+++++++++++++++++++|\n");
        System.out.println("-----------------------------------------------------------\n");
        lowestStockProduct.display();
    }
}
