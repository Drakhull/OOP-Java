package com.ecommerce.models;

import com.ecommerce.ui.CreateUserUI;
import com.ecommerce.ui.CreateProductUI;
import com.ecommerce.ui.LoginUI;

import java.util.Scanner;

public class Administrator extends User{
    public Administrator (String name, String email, String password)
        throws Exception {
        super(name, email, password);
    }

    public void createNewProduct(Scanner scanner) throws Exception {
        CreateProductUI.create(scanner);
    }

    public void createNewUser(Scanner scanner)
        throws Exception {
        CreateUserUI.menu(scanner);
    }

    public void showMenu(User user, Scanner scanner)
        throws Exception {

        LoginUI.menuAdmin(user, scanner);
    }
}
