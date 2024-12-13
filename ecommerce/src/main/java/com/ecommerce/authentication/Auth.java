package com.ecommerce.authentication;

import com.ecommerce.models.User;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Administrator;

import java.util.HashMap;

import javax.mail.internet.InternetAddress;

public class Auth {
    private Auth(){
    }

    public static boolean userEmailExists(HashMap users, String email)
        throws Exception {

            if (users.get(email) instanceof User){
                User user = (User) users.get(email);
                if (user == null) {
                    return false;
                }else return true;
            }

            return false;
    }

    public static boolean userPasswordExists(HashMap users, String email, String password)
        throws Exception {

        if (users.get(email) instanceof User){
            User user = (User) users.get(email);
            if (user == null || !user.isPasswordValid(password)){
                return false;
            }else return true;
        }

        return false;
    }
}
