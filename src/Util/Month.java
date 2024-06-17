package Util;

import java.time.DateTimeException;

public enum Month {

    JANUARY(1, "Январь", "January"),
    FEBRUARY(2, "Февраль", "February"),
    MARCH(3, "Январь", "March"),
    APRIL(4, "Апрель", "April"),
    MAY(5, "Май", "May"),
    JUNE(6, "Июнь", "June"),
    JULY(7, "Июль", "July"),
    AUGUST(8, "Август", "August"),
    SEPTEMBER(9, "Сентябрь", "September"),
    OCTOBER(10, "Октябрь", "October"),
    NOVEMBER(11, "Ноябрь", "November"),
    DECEMBER(12, "Декабрь", "December");

    private final int monthNum;

    private final String russianTitle;

    private final String englishTitle;

    private static final Month[] ENUMS = Month.values();

    Month(int monthNum, String russianTitle, String englishTitle) {
        this.monthNum = monthNum;
        this.russianTitle = russianTitle;
        this.englishTitle = englishTitle;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public static Month of(int month) {
        if (month < 1 || month > 12) {
            throw new DateTimeException("Invalid value for MonthOfYear: " + month);
        }
        return ENUMS[month - 1];
    }

    public String getRussianTitle() {
        return russianTitle;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }
}