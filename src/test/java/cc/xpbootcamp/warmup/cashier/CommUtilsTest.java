package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommUtilsTest {

    @Test
    void should_return_Tuesday_when_get_date_with_weekday_given_2020_2_18() {
        assertEquals("2020年2月18日，星期二", CommUtils.getDateWithWeekday( LocalDate.of(2020, 2, 18)));
    }

    @Test
    void should_return_Sunday_when_get_date_with_weekday_given_2020_2_16() {
        assertEquals("2020年2月16日，星期日", CommUtils.getDateWithWeekday( LocalDate.of(2020, 2, 16)));
    }

    @Test
    void should_return_wednesday_when_get_weekday_given_2020_2_19() {
        assertEquals("星期三", CommUtils.getWeekday( LocalDate.of(2020, 2, 19)));
    }
}