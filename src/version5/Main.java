
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

        EmployeeRoster roster = new EmployeeRoster();

        Name aliceName   = new Name("Alice", "Marie", "Smith");
        MyDate aliceDOB  = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);

        Name bobName   = new Name("Bob", "Carl", "Jones", "Jr.");
        MyDate bobDOB  = new MyDate(5, 4, 1998);
        MyDate bobHired = new MyDate(15, 1, 2023);

        Name mariaName  = new Name("Maria", "Lopez", "Reyes");
        MyDate mariaDOB = new MyDate(22, 9, 1990);
        MyDate mariaHired = new MyDate(10, 3, 2019);

        Name kevinName  = new Name("Kevin", "Sy", "Tan");
        MyDate kevinDOB = new MyDate(11, 12, 1985);
        MyDate kevinHired = new MyDate(5, 9, 2018);

        roster.addEmployee(new HourlyEmployee(101, aliceName, aliceDOB, aliceHired, 45.0f, 200.0));
        roster.addEmployee(new PieceWorkerEmployee(201, bobName, bobDOB, bobHired, 250, 15.0));
        roster.addEmployee(new CommissionEmployee(301, mariaName, mariaDOB, mariaHired, 100000.0));
        roster.addEmployee(new BasePlusCommissionEmployee(401, kevinName, kevinDOB, kevinHired, 160000.0, 8000.0));

        System.out.println("Enrolled: " + aliceName + " (Hourly)");
        System.out.println("Enrolled: " + bobName + " (Piece Worker)");
        System.out.println("Enrolled: " + mariaName + " (Commission)");
        System.out.println("Enrolled: " + kevinName + " (Base Plus Commission)");
        System.out.println("Total Roster Size: " + roster.countEmployee() + " employees");

        System.out.println();
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println();
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println();
        System.out.println("Removing Employee ID 201...");
        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployee());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
    }
}