package com.ecommerce.utils;

import java.io.*;

import com.ecommerce.controller.UsersRegistry;
import com.ecommerce.controller.ProductsRegistry;

import com.ecommerce.models.User;
import com.ecommerce.models.Product;

import java.util.HashMap;

public class SerializationUtils {

    public static void serializeData() {
        try (ObjectOutputStream usersStream = new ObjectOutputStream(new FileOutputStream("users.ser"));
             ObjectOutputStream productsStream = new ObjectOutputStream(new FileOutputStream("products.ser"))) {

            usersStream.writeObject(UsersRegistry.getUsers());

            productsStream.writeObject(ProductsRegistry.getProducts());

            System.out.println("Dados serializados com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeData() {
        try (ObjectInputStream usersStream = new ObjectInputStream(new FileInputStream("users.ser"));
             ObjectInputStream productsStream = new ObjectInputStream(new FileInputStream("products.ser"))) {

            UsersRegistry.setUsers((HashMap<String, User>) usersStream.readObject());

            ProductsRegistry.setProducts((HashMap<Integer, Product>) productsStream.readObject());

            System.out.println("Dados desserializados com sucesso!");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
