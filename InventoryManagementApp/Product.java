import java.math.BigDecimal;

public class Product {
    private static int idCounter;

    private int id;
    private int quantity;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;

    public Product(int quantity, String name, String description,
                   String category, String price) {
        this.id = idCounter++;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = new BigDecimal(price);
    }

//     teste para commit
// testando 2
}
