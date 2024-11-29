public class User {
    private static int idCounter;

    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    // private ?      ?;

    public User (String name, String email, String password, String address) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
