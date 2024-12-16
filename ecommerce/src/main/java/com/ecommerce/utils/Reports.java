package com.ecommerce.utils;

import com.ecommerce.models.ShoppingCart;
import com.ecommerce.models.Product;
import com.ecommerce.models.Order;

import java.math.BigDecimal;

public class Reports {
    private static ShoppingCart highestValuePurchase = null;
    private static Product lowestStockProduct = null;
// verify in deserialization
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
        if (highestValuePurchase != null){
            highestValuePurchase.display();
        }else System.out.println("------------------It's Empty------------------");
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
        if (highestValuePurchase != null){
            lowestStockProduct.display();
        }else System.out.println("------------------It's Empty------------------");
    }
}
