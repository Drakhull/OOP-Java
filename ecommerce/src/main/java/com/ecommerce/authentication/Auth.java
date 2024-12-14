package com.ecommerce.authentication;

import com.ecommerce.models.User;
import com.ecommerce.models.UsersRegistry;
import com.ecommerce.models.Customer;
import com.ecommerce.models.Administrator;

import java.util.HashMap;

import javax.mail.internet.InternetAddress;

public class Auth {
    private Auth(){
    }

    public static boolean userPasswordExists(String email, String password)
        throws Exception {

        if (UsersRegistry.get(email) instanceof User){
            User user = (User) UsersRegistry.get(email);
            if (user == null || !user.isPasswordValid(password)){
                return false;
            }else return true;
        }

        return false;
    }
}
