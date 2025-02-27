package br.edu.ifba.inf008;

import java.io.Serializable;


public class User implements Serializable {
    private static int idCounter = 0;

    private int id;
    private String name;

    public User(){
    }

    public User (String name, String email, String password)
        throws Exception {

        this.id = idCounter++;
        this.name = name;
    }
}
