@SuppressWarnings("unused")
public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    private static final double BIRTHDAY_BONUS = 5000.00;


    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate,
                                      MyDate dateHired, double totalSale, double baseSalary) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = (baseSalary < 0) ? 0 : baseSalary;
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
        double total = baseSalary + (totalSale * getCommissionRate());
        if (birthDate.getMonth() == currentMonth) {
            total += BIRTHDAY_BONUS;
        }
        return total;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sale: ₱%.2f, Base Salary: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalSale, baseSalary, computeSalary());
    }
}