package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.Constant.discountRate;
import static cc.xpbootcamp.warmup.cashier.Constant.wednesday;

public class Order {
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

    String getLineItemsPrint(String format) {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : lineItems) {
            result.append(lineItem.format(format));
        }
        return result.toString();
    }

    String getDateWithWeekday() {
        return CommUtils.getDateWithWeekday(date);
    }

    Double getDiscountAmount() {
        return getTotalOrderAmount() * (1 - discountRate);
    }

    Double getDiscountedTotalAmount() {
        return isDiscount() ? getTotalOrderAmount() * discountRate : getTotalOrderAmount();
    }

    boolean isDiscount() {
        return isWednesday();
    }

    Double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItems) {
            totalSalesTax += lineItem.getSalesTax();
        }
        return totalSalesTax;
    }

    private Double getTotalOrderAmount() {
        double totalOrderAmount = 0d;
        for (LineItem lineItem : lineItems) {
            totalOrderAmount += lineItem.getTotalAmount();
        }
        return totalOrderAmount;
    }

    private boolean isWednesday() {
        return DayOfWeek.WEDNESDAY.equals(date.getDayOfWeek());
    }
}
