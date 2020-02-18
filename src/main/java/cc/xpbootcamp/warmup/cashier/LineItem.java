package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.Constant.taxRate;

public class LineItem {

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

    public String format(String format ) {
        return  String.format(format, description, price, quantity, getAmount());
    }
}