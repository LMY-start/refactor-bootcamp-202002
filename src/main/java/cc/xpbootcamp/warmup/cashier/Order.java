package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

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

    @Override
    public String toString() {
        return customerName + customerAddress;
    }

    public String getLineItemsPrint() {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : lineItems) {
            result.append(lineItem);
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

    public  String getDateWithWeekday(){
        return CommUtils.getDateWithWeekday(date);
    }
}
