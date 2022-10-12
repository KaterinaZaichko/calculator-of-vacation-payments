package models;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

public class Calculator {
    public final String formatOfVacationPayments = "#0.00";
    public final double AVERAGE_AMOUNT_DAY_IN_MONTH = 29.3;
    private double averageSalary;
    private LocalDate startDateOfVacation;
    private LocalDate endDateOfVacation;

    public Calculator() {

    }

    public Calculator(double averageSalary, LocalDate startDateOfVacation, LocalDate endDateOfVacation) {
        this.averageSalary = averageSalary;
        this.startDateOfVacation = startDateOfVacation;
        this.endDateOfVacation = endDateOfVacation;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public LocalDate getStartDateOfVacation() {
        return startDateOfVacation;
    }

    public void setStartDateOfVacation(LocalDate startDateOfVacation) {
        this.startDateOfVacation = startDateOfVacation;
    }

    public LocalDate getEndDateOfVacation() {
        return endDateOfVacation;
    }

    public void setEndDateOfVacation(LocalDate endDateOfVacation) {
        this.endDateOfVacation = endDateOfVacation;
    }

    private boolean isWeekend(LocalDate localDate) {
        final DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    private static MonthDay toMonthDay(LocalDate localDate) {
        return MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
    }

    private boolean isHoliday(LocalDate localDate) {
        return isWeekend(localDate) || PublicHolidays.publicHolidays.contains(toMonthDay(localDate));
    }

    private int getAmountVacationDays() {
        int amountVacationDays = 0;
        if(startDateOfVacation != null && endDateOfVacation != null &&
                (startDateOfVacation.isEqual(endDateOfVacation) || startDateOfVacation.isBefore(endDateOfVacation))) {
            for(LocalDate i = startDateOfVacation; !i.isAfter(endDateOfVacation); i = i.plusDays(1)) {
                if (!isHoliday(i)) {
                    amountVacationDays++;
                }
            }
        }
        return amountVacationDays;
    }

    public String getVacationPayments() {
        return new DecimalFormat(formatOfVacationPayments).format(averageSalary / AVERAGE_AMOUNT_DAY_IN_MONTH * getAmountVacationDays());
    }
}
