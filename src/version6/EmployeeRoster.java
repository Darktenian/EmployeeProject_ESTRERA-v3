@SuppressWarnings("unused")
public class EmployeeRoster {
    private final java.util.List<Employee> empList;
    private Employee emp;

    public EmployeeRoster() {
        this.empList = new java.util.ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.empList = new java.util.ArrayList<>(initialCapacity);
    }

    public void addEmployee() {
        addEmployee(null);
    }

    public void addEmployee(Employee emp) {
        this.emp = emp;
        if (emp == null) throw new NullPointerException("Employee cannot be null");
        empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) return emp;
        }
        return null;
    }

    public int countEmployee() {
        return empList.size();
    }

    public int countHE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp.getClass() == CommissionEmployee.class) c++;
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            double base = emp.computeSalary();
            String note = (salary - base) > 0 ? " (Bonus Applied)" : "";
            System.out.printf("ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary, note);
        }
    }

    public void displayAllEmployees() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }
}