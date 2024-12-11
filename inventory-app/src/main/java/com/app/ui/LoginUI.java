package com.app.ui.LoginUI;

import com.app.authentication.Login;
import com.app.users.UsersHashMap;

import java.util.Scanner;

public abstract class LoginUI{
    public void loginMenu() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("E-mail: ");
        String email = scanner.next();

        System.out.println(Login.searchEmail());

        System.out.println("Password: ");
        String password = scanner.next();

        System.out.println(Login.searchPassword(password));


        scanner.close();
    }
}
