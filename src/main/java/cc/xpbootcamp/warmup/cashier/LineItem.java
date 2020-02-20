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

    private double getAmount() {
        return price * quantity;
    }

    double getSalesTax() {
        return getAmount() * taxRate;
    }

    double getTotalAmount() {
        return getAmount() + getSalesTax();
    }

    String format(String format) {
        return String.format(format, description, price, quantity, getAmount());
    }
}