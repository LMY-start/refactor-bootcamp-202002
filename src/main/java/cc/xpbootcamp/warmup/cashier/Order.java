package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private final static double discountRate = .98;

    private String customerName;
    private String customerAddress;
    private LocalDate date;
    private List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        this.date = LocalDate.now();
    }

    public Order(String customerName, String customerAddress, List<LineItem> lineItems, LocalDate date) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        this.date = date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    String getDateWithWeekday() {
        return DateFormatter.getDateWithWeekday(date);
    }

    double calculateDiscountAmount() {
        return calculateTotalOrderAmount() * (1 - discountRate);
    }

    double calculateDiscountedTotalAmount() {
        return isDiscount() ? calculateTotalOrderAmount() * discountRate : calculateTotalOrderAmount();
    }

    boolean isDiscount() {
        return isWednesday();
    }

    double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItems) {
            totalSalesTax += lineItem.getSalesTax();
        }
        return totalSalesTax;
    }

    private Double calculateTotalOrderAmount() {
        double totalOrderAmount = 0d;
        for (LineItem lineItem : lineItems) {
            totalOrderAmount += lineItem.calculateTotalAmount();
        }
        return totalOrderAmount;
    }

    private boolean isWednesday() {
        return DayOfWeek.WEDNESDAY.equals(date.getDayOfWeek());
    }
}
