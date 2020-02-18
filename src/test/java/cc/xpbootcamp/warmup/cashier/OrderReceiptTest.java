package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.Constant.DIVIDING_LINE;
import static cc.xpbootcamp.warmup.cashier.Constant.NEW_HEADER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();
        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }

    @Test
    public void should_print_date_when_print_new_receipt_give_a_order() {
        Order order = new Order(null, null, new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printNewReceipt();
        String weekday = WeekDay.of(order.date).getValue();

        assertThat(output, containsString(NEW_HEADER));
        assertThat(output, containsString(weekday));
    }

    @Test
    public void should_print_line_items_when_print_new_receipt_give_a_order() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printNewReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString(DIVIDING_LINE));
    }

    @Test
    public void should_print_totalSalesTax_and_totalAmount_items_when_print_new_receipt_give_a_order() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printNewReceipt();

        assertThat(output, containsString("税额: 5.30\n"));
        assertThat(output, containsString("总价: 58.30\n"));
    }

    @Test
    public void should_print_line_items_right_when_print_new_receipt_give_a_order_with_date_is_Wednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};

        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-19")));

        String output = receipt.printNewReceipt();

        assertThat(output, containsString("税额: 5.30\n"));
        assertThat(output, containsString("折扣: 1.17\n"));
        assertThat(output, containsString("总价: 57.13\n"));
    }


}