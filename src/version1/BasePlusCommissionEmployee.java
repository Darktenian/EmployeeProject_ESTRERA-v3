package version1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;


    public BasePlusCommissionEmployee() {
        this(0, "N/A", 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this(empID, empName, 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        setEmpID(empID);
        setEmpName(empName);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }


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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale < 0 ? 0 : totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary < 0 ? 0 : baseSalary;
    }

    public double computeSalary() {
        double sales = totalSale;
        double commissionRate;
        if (sales < 50000) {
            commissionRate = 0.05;
        } else if (sales < 100000) {
            commissionRate = 0.10;
        } else if (sales < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }
        return baseSalary + (sales * commissionRate);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                empID, empName, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Sale: ₱%.2f, Base Salary: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, totalSale, baseSalary, computeSalary());
    }
}