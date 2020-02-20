package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static cc.xpbootcamp.warmup.cashier.Constant.dateFormat;
import static cc.xpbootcamp.warmup.cashier.Constant.weekDayFormat;

public class CommUtils {

    public static String getDateWithWeekday(LocalDate date) {
        return DateTimeFormatter.ofPattern(dateFormat, Locale.CHINA).format(date);
    }

    public static String getWeekday(LocalDate date) {
        return DateTimeFormatter.ofPattern(weekDayFormat, Locale.CHINA).format(date);
    }
}
