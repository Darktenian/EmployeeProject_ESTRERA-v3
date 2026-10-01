@SuppressWarnings("unused")
public final class MyDate implements Cloneable {
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
        if (day < 1 || day > maxDays(month, year)) {
            throw new IllegalArgumentException("Invalid day for the specified month");
        }
        this.day = day;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid calendar date: month must be 1-12");
        }
        this.month = month;
        if (day > maxDays(month, year)) day = maxDays(month, year);
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date: year must be > 1900");
        }
        this.year = year;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int maxDays(int month, int year) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
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
        return java.util.Objects.hash(day, month, year);
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