

import java.util.Objects;
@SuppressWarnings("unused")
public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() { return day; }
    public void setDay(int day) {
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : 1;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        this.year = (year < 1) ? 2000 : year;
    }

    public void displayDate() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%02d %s %d", day, MONTHS[month - 1], year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}