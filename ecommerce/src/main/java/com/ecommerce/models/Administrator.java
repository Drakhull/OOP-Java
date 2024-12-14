package com.ecommerce.models;

import com.ecommerce.ui.CreateUserUI;
import com.ecommerce.ui.CreateProductUI;

import com.ecommerce.ui.LoginUI;

public class Administrator extends User{
    public Administrator (String name, String email, String password)
        throws Exception {
        super(name, email, password);
    }

    public void createNewProduct() throws Exception {
        CreateProductUI.create();
    }

    public void createNewUser()
        throws Exception {
        CreateUserUI.menu();
    }

    public void showMenu(User user)
        throws Exception {

        LoginUI.menuAdmin(user);
    }
}
