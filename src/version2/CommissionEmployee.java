@SuppressWarnings("unused")
public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    private static final double BIRTHDAY_BONUS = 5000.00;

    public CommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0);
    }

    public CommissionEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0);
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate,
                              MyDate dateHired, double totalSale) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
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

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        this.totalSale = (totalSale < 0) ? 0 : totalSale;
    }

    private double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public double computeSalary(int currentMonth) {
        double total = totalSale * getCommissionRate();
        if (birthDate.getMonth() == currentMonth) {
            total += BIRTHDAY_BONUS;
        }
        return total;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: ₱%.2f%n",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sale: ₱%.2f, Commission Salary: ₱%.2f]",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalSale, computeSalary());
    }
}
