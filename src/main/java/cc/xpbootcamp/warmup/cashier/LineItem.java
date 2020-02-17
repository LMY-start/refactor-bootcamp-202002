package cc.xpbootcamp.warmup.cashier;

public class LineItem {

    final static double taxRate = .10;
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

    public double getSalesTax() {
        return getAmount() * taxRate;
    }

    public double getTotalAmount() {
        return getAmount() + getSalesTax();
    }

    @Override
    public String toString() {
        return description + '\t'
                + price + '\t'
                + quantity + '\t'
                + getAmount() + '\n';
    }
}