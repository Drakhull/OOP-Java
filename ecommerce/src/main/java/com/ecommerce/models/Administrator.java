package com.ecommerce.models;

import com.ecommerce.ui.CreateUserUI;

public class Administrator extends User{
    public Administrator (String name, String email, String password)
        throws Exception {
        super(name, email, password);
    }

    public Product createNewProduct() {
        return null;
    }

    public void createNewUser()
        throws Exception {
        CreateUserUI.menu();
    }
}
