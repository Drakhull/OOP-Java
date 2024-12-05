import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private static int orderCounter = 0;

    private int orderNumber;
    private String date;
    private ArrayList<Product> products;
    private BigDecimal totalValue;

    public Order (String date, String totalValue) {
        this.date = date;
        this.products = new ArrayList<Product>();
        this.totalValue = new BigDecimal(totalValue);
    }
}
