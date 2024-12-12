package com.ecommerce.authentication;

import com.ecommerce.users.User;
import com.ecommerce.users.Customer;
import com.ecommerce.users.Administrator;
import com.ecommerce.users.UsersHashMap;

import javax.mail.internet.InternetAddress;

public abstract class Login {
    public static boolean searchUserEmail(String email)
        throws Exception {

            User user = UsersHashMap.getUserByEmail(email);
            if (user == null) {
                return false;
            }

            return true;
    }

    public static boolean searchUserPassword(String email, String password)
        throws Exception {

        User user = UsersHashMap.getUserByEmail(email);
        if (user == null || !user.isPasswordValid(password)){
            return false;
        }

        return true;
    }
}
