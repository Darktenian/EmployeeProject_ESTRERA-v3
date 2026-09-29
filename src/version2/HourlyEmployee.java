@SuppressWarnings("unused")
public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    private static final double BIRTHDAY_BONUS = 5000.00;


    public HourlyEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0f, 0.0);
    }

    public HourlyEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0f, 0.0);
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate,
                          MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }


    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) {
        this.empName = (empName == null) ? new Name() : empName;
    }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) {
        this.birthDate = (birthDate == null) ? new MyDate() : birthDate;
    }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) {
        this.dateHired = (dateHired == null) ? new MyDate() : dateHired;
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = (totalHoursWorked < 0) ? 0 : totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = (ratePerHour < 0) ? 0 : ratePerHour;
    }


    public double computeSalary() {
        return computeSalary(-1); // no birthday bonus
    }

    public double computeSalary(int currentMonth) {
        double base;
        if (totalHoursWorked <= 40) {
            base = totalHoursWorked * ratePerHour;
        } else {
            double regular = 40 * ratePerHour;
            double overtime = (totalHoursWorked - 40) * ratePerHour * 1.5;
            base = regular + overtime;
        }
        if (birthDate.getMonth() == currentMonth) {
            base += BIRTHDAY_BONUS;
        }
        return base;
    }


    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalHoursWorked, ratePerHour, computeSalary());
    }
}