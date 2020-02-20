package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    private final static String LINE_ITEM_FORMAT = "%s, %.2f x %d, %.2f\n";

    private final static String HEADER = "===== 老王超市，值得信赖 ======\n";
    private final static String DIVIDING_LINE = "-----------------------------------\n";

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeader(output);
        printDate(output);
        printLineItems(output);
        printDividingLine(output);
        printTotal(output);

        return output.toString();
    }

    private void printHeader(StringBuilder output) {
        output.append(HEADER + "\n");
    }

    private void printDate(StringBuilder output) {
        output.append(order.getDateWithWeekday()).append("\n\n");
    }

    private void printLineItems(StringBuilder output) {
        order.getLineItems().forEach(lineItem -> output.append(lineItem.format(LINE_ITEM_FORMAT)));
    }

    private void printDividingLine(StringBuilder output) {
        output.append(DIVIDING_LINE);
    }

    private void printTotal(StringBuilder output) {
        output.append(String.format("税额: %.2f\n", order.getTotalSalesTax()));
        if (order.isDiscount()) {
            output.append(String.format("折扣: %.2f\n", order.getDiscountAmount()));
        }
        output.append(String.format("总价: %.2f\n", order.getDiscountedTotalAmount()));
    }
}