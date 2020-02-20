package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;

public enum WeekDay {
    Monday("星期一"),
    Tuesday("星期二"),
    Wednesday("星期三"),
    Thursday("星期四"),
    Friday("星期五"),
    Saturday("星期六"),
    Sunday("星期日");

    private String value;

    WeekDay(String value) {
        this.value = value;
    }

    public static WeekDay of(LocalDate date) {
        return WeekDay.values()[date.getDayOfWeek().getValue()-1];
    }

}
