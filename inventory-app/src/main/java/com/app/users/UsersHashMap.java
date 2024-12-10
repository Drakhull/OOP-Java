package com.app.users;

import java.util.HashMap;

public class UsersHashMap {
    private static HashMap<String, User> users = new HashMap<>();

    public static void addUser(User user, String email) {
        users.put(email, user);
    }

    public static User getUserByEmail(String email) {
        return users.get(email);
    }

    public static boolean removeUser(String email) {
        return users.remove(email) != null;
    }

    public static HashMap<String, User> getAllUsers() {
        return users;
    }
}
