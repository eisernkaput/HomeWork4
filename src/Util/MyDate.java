package Util;

import java.time.DateTimeException;
import java.util.Objects;

public class MyDate {

    private int year;

    private Month month;

    private int day;

    private int hour;

    private int minute;

    private int second;

    public MyDate(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = Month.of(month);
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public MyDate(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month.getMonthNum();
    }

    public void setMonth(int month) {
        this.month = Month.of(month);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new DateTimeException("Invalid value for day number: " + month);
        }
        this.day = day;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 1 || minute > 60) {
            throw new DateTimeException("Invalid value for minute: " + month);
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (minute < 1 || minute > 60) {
            throw new DateTimeException("Invalid value for second: " + month);
        }
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public MyDate plusYears(int years) {
        return new MyDate(this.getYear() + years,this.getMonth(),this.getDay(),this.getHour(),this.getMinute(),this.getSecond());
    }

    public MyDate plusMonths(int months) {
        int monthNum = this.getMonth();
        if (monthNum == 12) monthNum = 0;
        return new MyDate(this.getYear(),monthNum + months,this.getDay(),this.getHour(),this.getMinute(),this.getSecond());
    }

    public MyDate plusDays(int days) {
        int curDays = this.getDay();
        int monthNum = this.getMonth();
        if (curDays == 31) {
            curDays = 0;
            monthNum++;
        }
        if (monthNum > 12) monthNum = 1;
        return new MyDate(this.getYear(),monthNum,curDays + days,this.getHour(),this.getMinute(),this.getSecond());
    }

    public boolean isAfter(MyDate myDate) {
        return this.getYear() > myDate.getYear() || this.getMonth() > myDate.getMonth() || this.getDay() > myDate.getDay();
    }

    @Override
    public String toString() {
        return formatNum(this.getDay()) + "." + formatNum(this.getMonth()) + "." + this.getYear();
    }

    private String formatNum(int num) {
        return num < 10 ? "0" + num : String.valueOf(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDate myDate)) return false;
        return year == myDate.year && day == myDate.day && hour == myDate.hour && minute == myDate.minute && second == myDate.second && month == myDate.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, hour, minute, second);
    }
}
