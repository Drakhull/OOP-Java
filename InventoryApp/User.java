public class User {
    private static int idCounter;

    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    // private ?      ?;

    public User (String name, String email, String password, String address) throws Exception {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.password = PasswordHashing.generateHash(password);
        this.address = address;
    }

    public void display(){
        System.out.println("ID: " + id + "\nName: " + name + "\nE-Mail: " + email +
                           "\nPassword: " + password + "\nAddress: " + address);
    }

    public boolean validatePassword(String passwordToValidate) throws Exception {
       return PasswordHashing.validatePassword(passwordToValidate, password);
    }
}
