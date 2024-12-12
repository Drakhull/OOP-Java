package com.ecommerce.models;

public class Administrator extends User{
    public Administrator (String name, String email, String password)
        throws Exception {
        super(name, email, password);
    }

    public Product createNewProduct() {
        return null;
    }
    public Product createNewUser() {
        return null;
    }
}
