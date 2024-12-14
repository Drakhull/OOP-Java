package com.ecommerce.authentication;

import com.ecommerce.controller.UsersRegistry;
import com.ecommerce.models.User;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

public class Validation {
    private Validation(){
    }

    public static boolean isNameValid(String name) {
        if (name == null || name.trim().isEmpty())
            return false;

        // regex to verify if the name has only letters and spaces
        String nameRegex = "^[a-zA-Z ]+$";

        return name.matches(nameRegex);
    }

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            else if (isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
        }

        return hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar;
    }

    private static boolean isSpecialCharacter(char c) {
        String specialChars = "!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?";
        return specialChars.indexOf(c) >= 0;
    }


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
