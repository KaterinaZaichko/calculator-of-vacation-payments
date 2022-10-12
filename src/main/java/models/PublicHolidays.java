package models;
import java.time.Month;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

public class PublicHolidays {
    public final static Set<MonthDay> publicHolidays = new HashSet<>();;

    static {
        publicHolidays.add(MonthDay.of(Month.JANUARY, 1));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 2));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 3));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 4));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 5));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 6));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 7));
        publicHolidays.add(MonthDay.of(Month.JANUARY, 8));
        publicHolidays.add(MonthDay.of(Month.FEBRUARY, 23));
        publicHolidays.add(MonthDay.of(Month.MARCH, 8));
        publicHolidays.add(MonthDay.of(Month.MAY, 1));
        publicHolidays.add(MonthDay.of(Month.MAY, 9));
        publicHolidays.add(MonthDay.of(Month.JUNE, 12));
        publicHolidays.add(MonthDay.of(Month.NOVEMBER, 4));
    }
}