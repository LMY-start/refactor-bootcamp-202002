package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderReceiptTest {

    @Test
    public void should_print_right_header_when_print_receipt_give_a_order() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order("my", "xian", lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======\n"));
    }

    @Test
    public void should_print_right_date_when_print_receipt_give_a_order() throws ParseException {
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, new ArrayList<>(),new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-18")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月18日"));
    }

    @Test
    public void should_print_line_items_right_and_have_divided_line_when_print_receipt_give_a_order() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("-----------------------------------\n"));
    }

    @Test
    public void should_print_totalSalesTax_and_totalAmount_right_when_print_receipt_give_a_order_with_date_is_not_Wednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-18")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("税额: 5.30\n"));
        assertThat(output, containsString("总价: 58.30\n"));
    }

    @Test
    public void should_print_totalSalesTax_and_totalAmount_right_when_print_receipt_give_a_order_with_date_is_Wednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-19")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("税额: 5.30\n"));
        assertThat(output, containsString("折扣: 1.17\n"));
        assertThat(output, containsString("总价: 57.13\n"));
    }

    @Test
    public void should_print_all_right_when_print_new_receipt_give_a_order_with_date_is_Wednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};

        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-19")));
        String expected = "===== 老王超市，值得信赖 ======\n"
                + "\n"
                + "2020年2月19日，星期三\n"
                + "\n"
                + "巧克力, 21.50 x 2, 43.00\n"
                + "小白菜, 10.00 x 1, 10.00\n"
                + "-----------------------------------\n"
                + "税额: 5.30\n"
                + "折扣: 1.17\n"
                + "总价: 57.13\n";

        String output = receipt.printReceipt();

        assertEquals(expected, output);
    }

}