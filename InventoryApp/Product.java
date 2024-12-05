import java.math.BigDecimal;

public class Product {
    private static int idCounter = 0;

    private int id;
    private int quantity;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;

    public Product(String name, int quantity, String description,
                   String category, String price) {
        this.id = idCounter++;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = new BigDecimal(price);
    }

    public void display() {
        System.out.println("\nID: " + id + "\nName: " + name + "\nPrice: " + "\nQuantity in stock: " + quantity +
                           "\nDescription: " + description + "\nCategory: " + category);
    }
}
