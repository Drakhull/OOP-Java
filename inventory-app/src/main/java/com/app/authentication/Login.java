package com.app.authentication;

import com.app.users.User;
import com.app.users.Customer;
import com.app.users.Administrator;
import com.app.users.UsersHashMap;

import javax.mail.internet.InternetAddress;
   // static
public abstract class Login {
//     public static User login(String email, String password)
//         throws Exception {
//
//         User user = UsersHashMap.getUserByEmail(email);
// //         should i use a exception or a try catch?
// //         is it a security breach to say if the e-mail exists or not?
//         if (user == null) {
//             System.out.println("User does not exists or invalid e-mail.");
//             return user;
//         }
//         if (user.isPasswordValid(password)){
//             System.out.println("Login successful\nWelcome!");
//             return user;
//         }
//         System.out.println("Invalid password.");
//
//         return user;
//     }

    public static boolean searchEmail(String email)
        throws Exception {

            User user = UsersHashMap.getUserByEmail(email);
            if (user == null) {
                System.out.println("User does not exists or invalid e-mail.");
                return false;
            }

            return true;
    }

    public static boolean searchPassword(String password) {
        if (!user.isPasswordValid(password)){
            System.out.println("Invalid password.");
            return false;
        }
        System.out.println("Login successful\nWelcome!");

        return true;
    }
// after finding the user, compare password getting the found user as a parameter

    // public boolean isPasswordValid

}
