package version1;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this(0, "N/A", 0.0f, 0.0f);
    }
    public HourlyEmployee(int empID, String empName) {
        this(empID, empName, 0.01f, 0.0f);
    }
    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour ) {
        setEmpID(empID);
        setEmpName(empName);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    // Area for Getters & Setters :3
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName != null ? empName : "N/A";
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked < 0 ? 0 : totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour < 0 ? 0 : ratePerHour;
    }

    public double computeSalary() {
        float hours = totalHoursWorked;
        double rate = ratePerHour;
        if (hours <= 40) {
            return hours * rate;
        } else {
            double regularPay = 40 * rate;
            double overtimePay = (hours - 40) * rate * 1.5;
            return regularPay + overtimePay;
        }
    }
    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr%n", empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%.2f Total Salary: ₱%.2f]",
                empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
}
