package com.ecommerce.authentication;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

public class Validation {
    public static boolean isUserValid(String name, String email, String password) {
        String errorMessage = null;
        if (!Validation.isEmailValid(email)) {
            errorMessage = "Invalid E-mail: " + email;
        } else if (password == null || password.length() < 6) {
            errorMessage = "Password must be 6 character length.";
        } else if (name == null || name.trim().isEmpty()) {
            errorMessage = "Name field can't be blank.";
        }

        if (errorMessage != null) {
            System.out.println(errorMessage);
            return false;
        }

        return true;
    }
//     public static boolean isCustomerValid(String name, String email, String password) {
//         if (!isUserValid(name, email, password)){
//             return false
//         } else if (String )
//     }
//
//     public static boolean isAdministratorValid(String name, String email, String password) {
//
//     }

    public static boolean isEmailValid(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
