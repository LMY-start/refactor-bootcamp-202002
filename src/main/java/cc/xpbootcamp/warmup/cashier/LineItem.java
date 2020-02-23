package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private final static double taxRate = .10;

    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double getAmount() {
        return price * quantity;
    }

    double getSalesTax() {
        return getAmount() * taxRate;
    }

    double calculateTotalAmount() {
        return getAmount() + getSalesTax();
    }
}