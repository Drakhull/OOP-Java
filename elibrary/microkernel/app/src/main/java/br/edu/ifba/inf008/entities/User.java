package br.edu.ifba.inf008;

import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String password;

    public User(){
    }

    public User (String name, String email, String password)
        throws Exception {

        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // public void display(){
    //     System.out.print("\nID: " + id +
    //                      "\nName: " + name +
    //                      "\nE-Mail: " + email +
    //                      "\nPassword: " + password);
    // }
    //
    // public void simpleDisplay(){
    //     System.out.print("\nID: " + id +
    //                      "\nName: " + name);
    // }
    //
    // public abstract void showMenu(User user, Scanner scanner) throws Exception;

    public boolean isPasswordValid(String password)
        throws Exception {

       return Objects.equals(this.password, password);
    }
}
