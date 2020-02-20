package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CommUtils {

    final static String dateFormat = "%s，%s";

    public static String getDateWithWeekday(LocalDate date) {
        return String.format(dateFormat,
                             DateTimeFormatter.ofPattern("yyyy年M月dd日", Locale.CHINA).format(date),
                             WeekDay.of(date).getValue());
    }
}
