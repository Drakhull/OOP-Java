package com.ecommerce.models;

import java.util.HashMap;
//  this class is necessary for the Administrator createNewUser logic, because
// theres no need to create a new HashMap for it since this class stores all users.
//  Despite the fact that it makes the application more flexible to changes if
// you want to change UsersHashMap to something else and excludes one
// additional parameter in other classes if it was declared in main

public class UsersRegistry {
     private static HashMap<String, User> users = new HashMap<>();

     private UsersRegistry(){
     }

    public static void put(User user) {
        users.put(user.getEmail(), user);
    }

    public static User get(String email) {
        return users.get(email);
    }

    public static boolean containsKey(String email) {
        return users.containsKey(email);
    }

    public static void displayUsers() {
        users.forEach((email, user) -> user.display());
    }
}
