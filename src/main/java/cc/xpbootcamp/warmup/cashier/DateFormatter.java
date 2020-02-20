package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {

    private final static String dateFormat = "yyyy年M月d日，EEEE";
    private final static String weekDayFormat = "EEEE";

    public static String getDateWithWeekday(LocalDate date) {
        return DateTimeFormatter.ofPattern(dateFormat, Locale.CHINA).format(date);
    }

    public static String getWeekday(LocalDate date) {
        return DateTimeFormatter.ofPattern(weekDayFormat, Locale.CHINA).format(date);
    }
}
