
@SuppressWarnings("unused")
public class EmployeeRoster {
    private final Employee[] empList;
    private final int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = Math.max(1, max);
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public int getCount() { return count; }
    public int getMax() { return max; }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) return false;
        empList[count++] = emp;
        return true;
    }

    public void removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[--count] = null;
                return;
            }
        }
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) return empList[i];
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) c++;
        }
        return c;
    }

    public int countBPC() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee he) {
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee pwe) {
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPC() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee bpc) {
                bpc.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployee() {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, e.getEmpID(), e.getEmpName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            double base;
            double total;
            String label;

            switch (e) {
                case BasePlusCommissionEmployee bpc -> {
                    label = "Base Plus Commission";
                    base = bpc.computeSalary(-1);
                    total = bpc.computeSalary(currentMonth);
                }
                case CommissionEmployee ce -> {
                    label = "Commission";
                    base = ce.computeSalary(-1);
                    total = ce.computeSalary(currentMonth);
                }
                case HourlyEmployee he -> {
                    label = "Hourly";
                    base = he.computeSalary(-1);
                    total = he.computeSalary(currentMonth);
                }
                case PieceWorkerEmployee pwe -> {
                    label = "Piece Worker";
                    base = pwe.computeSalary(-1);
                    total = pwe.computeSalary(currentMonth);
                }
                case null, default -> {
                    continue;
                }
            }

            double bonus = total - base;
            String note = bonus > 0 ? " (Birthday Bonus Applied)" : "";
            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                    label, e.getEmpID(), e.getEmpName(), total, note);
        }
    }
}