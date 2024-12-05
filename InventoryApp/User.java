import java.util.ArrayList;

public class User {
    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private ArrayList<ShoppingCart> purchaseHistory;

    private User (String name, String email, String password, String address)
        throws Exception {

        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.password = PasswordHashing.generateHash(password);
        this.address = address;
        this.purchaseHistory = new ArrayList<ShoppingCart>();
    }

    public void display(){
        System.out.println("ID: " + id +
                           "\nName: " + name +
                           "\nE-Mail: " + email +
                           "\nPassword: " + password +
                           "\nAddress: " + address
                           // "\n\nPurchase History: \n" + displayAllPurchases()
                           );
    }

    public void displayAllPurchases(){
        // for(ShoppingCart purchase : purchaseHistory)
        //     purchase.display();
    }

    public boolean validatePassword(String passwordToValidate)
        throws Exception {

       return PasswordHashing.validatePassword(passwordToValidate, password);
    }
}
