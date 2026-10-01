

import java.util.Objects;
@SuppressWarnings("unused")
public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = Math.max(0, totalHoursWorked);
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = Math.max(0, ratePerHour);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double base;
        if (totalHoursWorked <= 40) {
            base = totalHoursWorked * ratePerHour;
        } else {
            base = (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
        }
        if (getBirthDate().getMonth() == currentMonth) base += BIRTHDAY_BONUS;
        return base;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}