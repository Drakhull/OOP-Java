import java.math.BigDecimal;

public class Order {
    private static int orderCounter;

    private int orderNumber;
    private String date;
    private <Arraylist>Product<Arraylist> products;
    private BigDecimal totalValue;

    public Order (String date, Product products, String totalValue) {
        this.date = date;
        this.products =
        this.totalValue = new BigDecimal(totalValue);
    }
}
