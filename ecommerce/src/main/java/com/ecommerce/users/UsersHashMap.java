package com.ecommerce.users;

import java.util.HashMap;

public class UsersHashMap {
    private static HashMap<String, User> users = new HashMap<>();

    public static void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public static User getUserByEmail(String email) {
        return users.get(email);
    }

    public static boolean removeUser(User user) {
        return users.remove(user.getEmail()) != null;
    }

    public static HashMap<String, User> getAllUsers() {
        return users;
    }

    public static void displayAllUsers() {
       getAllUsers().forEach((email, user) -> {
            user.display();
        });
    }
}
