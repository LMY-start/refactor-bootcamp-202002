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
        output.append(order.getLineItemsPrint());
        output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
        output.append("Total Amount").append('\t').append(order.getTotalOrderAmount());

        return output.toString();
    }

}