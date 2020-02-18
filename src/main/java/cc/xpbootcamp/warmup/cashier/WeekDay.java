package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.Date;

public enum WeekDay {
    Sunday("星期日"),
    Monday("星期一"),
    Tuesday("星期二"),
    Wednesday("星期三"),
    Thursday("星期四"),
    Friday("星期五"),
    Saturday("星期六");

    private String value;

    WeekDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WeekDay of(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return WeekDay.values()[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

}
