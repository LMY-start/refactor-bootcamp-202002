package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommUtils {
    public static String getDateWithWeekday(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String dateStr = format.format(date);
        if (dateStr.contains("年0")) {
            dateStr = dateStr.replace("年0", "年");
        }
        return dateStr + "，" + WeekDay.of(date).getValue();
    }
}
