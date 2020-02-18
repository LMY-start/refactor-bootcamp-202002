package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.Constant.DIVIDING_LINE;
import static cc.xpbootcamp.warmup.cashier.Constant.FORMAT;
import static cc.xpbootcamp.warmup.cashier.Constant.HEADER;
import static cc.xpbootcamp.warmup.cashier.Constant.NEW_FORMAT;
import static cc.xpbootcamp.warmup.cashier.Constant.NEW_HEADER;

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

        output.append(HEADER);
        output.append(order);
        output.append(order.getLineItemsPrint(FORMAT));
        output.append(order.getTotalSalesTaAndTotalOrderAmount("Sales Tax\t%sTotal Amount\t%s"));
        return output.toString();
    }

    public String printNewReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(NEW_HEADER);
        output.append(order.getDateWithWeekday());
        output.append("\n\n");
        output.append(order.getLineItemsPrint(NEW_FORMAT));
        output.append(DIVIDING_LINE);
        output.append(order.getTotalSalesTaAndTotalOrderAmountWithDiscount("税额: %.2f\n折扣: %.2f\n总价: %.2f\n"));

        return output.toString();
    }
}