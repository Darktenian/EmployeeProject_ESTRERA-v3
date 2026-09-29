@SuppressWarnings("unused")
public class MyDate {
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
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 1;
        }
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
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
}