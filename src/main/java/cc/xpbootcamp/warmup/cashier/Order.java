package cc.xpbootcamp.warmup.cashier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.Constant.discountRate;

public class Order {
    String customerName;
    String customerAddress;
    Date date;
    List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        this.date = new Date();
    }

    public Order(String customerName, String customerAddress, List<LineItem> lineItems, Date date) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        this.date = date;
    }

    @Override
    public String toString() {
        return customerName + customerAddress;
    }

    public String getLineItemsPrint(String format) {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : lineItems) {
            result.append(lineItem.format(format));
        }
        return result.toString();
    }

    public Double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItems) {
            totalSalesTax += lineItem.getSalesTax();
        }
        return totalSalesTax;
    }

    public Double getTotalOrderAmount() {
        double totalOrderAmount = 0d;
        for (LineItem lineItem : lineItems) {
            totalOrderAmount += lineItem.getTotalAmount();
        }
        return totalOrderAmount;
    }

    public String getDateWithWeekday() {
        return CommUtils.getDateWithWeekday(date);
    }

    public String getTotalSalesTaAndTotalOrderAmount(String format) {
        return String.format(format, getTotalSalesTax(), getTotalOrderAmount());
    }

    public String getTotalSalesTaAndTotalOrderAmountWithDiscount(String format) {
        String result = String.format(format, getTotalSalesTax(),
                                      isWednesday() ? getTotalOrderAmount() * discountRate : 0,
                                      isWednesday() ? getTotalOrderAmount() * (1 - discountRate) : getTotalOrderAmount());
        if (!isWednesday()) {
            return Arrays.stream(result.split("\n")).filter(line -> !line.contains("0.00")).reduce("", (line1, line2) -> line1 + line2 + "\n");
        }
        return result;
    }

    private boolean isWednesday() {
        return WeekDay.Wednesday.equals(WeekDay.of(date));
    }
}
