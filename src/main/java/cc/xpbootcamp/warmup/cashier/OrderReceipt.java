package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

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
        return generateHeader() +
                generateDate() +
                generateLineItems() +
                generateTotal();
    }

    private String generateHeader() {
        return HEADER + "\n";
    }

    private String generateDate() {
        return order.getDateWithWeekday() + "\n\n";
    }

    private String generateLineItems() {
        return order.getLineItems().stream()
                .map(this::formatLineItem)
                .collect(Collectors.joining());
    }

    private String formatLineItem(LineItem lineItem) {
        return String.format(LINE_ITEM_FORMAT,
                             lineItem.getDescription(),
                             lineItem.getPrice(),
                             lineItem.getQuantity(),
                             lineItem.getAmount());
    }

    private String generateTotal() {
        StringBuilder output = new StringBuilder();
        output.append(DIVIDING_LINE);
        output.append(String.format("税额: %.2f\n", order.getTotalSalesTax()));
        if (order.isDiscount()) {
            output.append(String.format("折扣: %.2f\n", order.getDiscountAmount()));
        }
        output.append(String.format("总价: %.2f\n", order.getDiscountedTotalAmount()));
        return output.toString();
    }
}