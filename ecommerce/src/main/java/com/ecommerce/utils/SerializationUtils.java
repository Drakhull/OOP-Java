package com.ecommerce.utils;

import java.io.*;
import com.ecommerce.controller.UsersRegistry;
import com.ecommerce.controller.ProductsRegistry;
import com.ecommerce.models.User;
import com.ecommerce.models.Product;
import com.ecommerce.models.ShoppingCart;
import com.ecommerce.models.Product;
import com.ecommerce.utils.Reports;
import java.util.HashMap;

public class SerializationUtils {

    public static void serializeData() {
        try (ObjectOutputStream usersStream = new ObjectOutputStream(new FileOutputStream("users.ser"));
             ObjectOutputStream productsStream = new ObjectOutputStream(new FileOutputStream("products.ser"));
             ObjectOutputStream reportsStream = new ObjectOutputStream(new FileOutputStream("reports.ser"))) {

            usersStream.writeObject(UsersRegistry.getUsers());
            productsStream.writeObject(ProductsRegistry.getProducts());

            reportsStream.writeObject(Reports.getHighestValuePurchase());  // Exemplo de serialização
            reportsStream.writeObject(Reports.getLowestStockProduct());  // Exemplo de serialização

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeData() {
        try (ObjectInputStream usersStream = new ObjectInputStream(new FileInputStream("users.ser"));
             ObjectInputStream productsStream = new ObjectInputStream(new FileInputStream("products.ser"));
             ObjectInputStream reportsStream = new ObjectInputStream(new FileInputStream("reports.ser"))) {

            UsersRegistry.setUsers((HashMap<String, User>) usersStream.readObject());
            ProductsRegistry.setProducts((HashMap<Integer, Product>) productsStream.readObject());

            Reports.setHighestValuePurchase((ShoppingCart) reportsStream.readObject());
            Reports.setLowestStockProduct((Product) reportsStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
