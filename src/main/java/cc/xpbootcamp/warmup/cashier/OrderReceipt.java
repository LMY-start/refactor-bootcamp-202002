package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    public final static String HEADER = "======Printing Orders======\n";
    public final static String NEW_HEADER = "===== 老王超市，值得信赖 ======\n\n";
    public final static String DIVIDING_LINE = "-----------------------------------\n";
    public final static String NEW_FORMAT = "%s, %.2f x %d, %.2f\n";
    public final static String FORMAT = "%s\t%s\t%s\t%s\n";


    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(HEADER);
        output.append(order);
        output.append(order.getLineItemsPrint(FORMAT));
        output.append(order.getTotalSalesTaAndTotalOrderAmountWithFormat("Sales Tax\t%sTotal Amount\t%s"));
        return output.toString();
    }

    public String printNewReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(NEW_HEADER);
        output.append(order.getDateWithWeekday());
        output.append("\n\n");
        output.append(order.getLineItemsPrint(NEW_FORMAT));
        output.append(DIVIDING_LINE);
        output.append(order.getTotalSalesTaAndTotalOrderAmountWithFormat("税额: %.2f\n总价: %.2f\n"));

        return output.toString();
    }
}