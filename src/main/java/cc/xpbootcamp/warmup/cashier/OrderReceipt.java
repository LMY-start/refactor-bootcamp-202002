package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");
        output.append(order);
        output.append(getLineItemsPrint());
        output.append("Sales Tax").append('\t').append(getTotalSalesTax());
        output.append("Total Amount").append('\t').append(getTotalOrderAmount());

        return output.toString();
    }

    private String getLineItemsPrint() {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : order.getLineItems()) {
            result.append(lineItem);
        }
        return result.toString();
    }

    private Double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSalesTax += lineItem.getSalesTax();
        }
        return totalSalesTax;
    }

    private Double getTotalOrderAmount() {
        double totalOrderAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalOrderAmount += lineItem.getTotalAmount();
        }
        return totalOrderAmount;
    }
}