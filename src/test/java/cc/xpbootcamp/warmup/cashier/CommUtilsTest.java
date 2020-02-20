package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommUtilsTest {

    @Test
    void should_return_Tuesday_when_get_dateWithWeekday_given_2020_2_18() {
        LocalDate date = LocalDate.of(2020, 2, 18);
        String dateWithWeekday = CommUtils.getDateWithWeekday(date);
        assertEquals("2020年2月18日，星期二", dateWithWeekday);
    }

    @Test
    void should_return_Sunday_when_get_dateWithWeekday_given_2020_2_16() {
        LocalDate date = LocalDate.of(2020, 2, 16);
        String dateWithWeekday = CommUtils.getDateWithWeekday(date);
        assertEquals("2020年2月16日，星期日", dateWithWeekday);
    }
}