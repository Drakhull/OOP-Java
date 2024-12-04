public class Main {
    public static void main(String[] args) throws Exception{
        User user = new User("Iuri Viana", "iuri@gmail.com", "senha123", "Quinto dos infernos");
        user.display();
        System.out.println("\n\nsenha123: " + user.validatePassword("senha123") +
                           "\ntaerrado: " + user.validatePassword("taerrado"));
    }
}
