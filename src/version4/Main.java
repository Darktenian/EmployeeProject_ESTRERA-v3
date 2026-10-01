
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

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

        Name davidName  = new Name("David", "Aquino", "White");
        MyDate davidDOB = new MyDate(15, 3, 1995);
        MyDate davidHired = new MyDate(20, 7, 2021);

        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        EmployeeRoster roster = new EmployeeRoster(6);

        addWithFeedback(roster, new HourlyEmployee(101, aliceName, aliceDOB, aliceHired, 45.0f, 200.0));
        addWithFeedback(roster, new PieceWorkerEmployee(201, bobName, bobDOB, bobHired, 250, 15.0));
        addWithFeedback(roster, new CommissionEmployee(301, mariaName, mariaDOB, mariaHired, 100000.0));
        addWithFeedback(roster, new BasePlusCommissionEmployee(401, kevinName, kevinDOB, kevinHired, 160000.0, 8000.0));
        addWithFeedback(roster, new HourlyEmployee(102, davidName, davidDOB, davidHired, 40.0f, 200.0));

        System.out.println();
        System.out.println("[Capacity Test] Attempting to fill remaining slot and exceed capacity:");
        Name tempName = new Name("Temp", "T.", "Worker");
        addWithFeedback(roster, new HourlyEmployee(999, tempName,
                new MyDate(1, 1, 2001), new MyDate(1, 1, 2021), 10.0f, 100.0));
        addWithFeedback(roster, new HourlyEmployee(1000, tempName,
                new MyDate(1, 1, 2001), new MyDate(1, 1, 2021), 10.0f, 100.0));
        roster.removeEmployee(999);

        System.out.println();
        System.out.println("- - - ROSTER COMPOSITION COUNTS - -");
        System.out.printf("Total Employees: %d / %d%n", roster.getCount(), roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPC());

        System.out.println();
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        roster.removeEmployee(201);
        roster.displayAllEmployee();
    }

    private static void addWithFeedback(EmployeeRoster roster, Employee emp) {
        boolean ok = roster.addEmployee(emp);
        String type = emp.getClass().getSimpleName();
        String friendly = switch (emp) {
            case BasePlusCommissionEmployee basePlusCommissionEmployee -> "Base Plus Commission";
            case CommissionEmployee commissionEmployee -> "Commission";
            case HourlyEmployee hourlyEmployee -> "Hourly";
            case PieceWorkerEmployee pieceWorkerEmployee -> "Piece Worker";
            default -> type;
        };

        if (ok) {
            System.out.printf("Added: %s (%s) -> Success%n", emp.getEmpName(), friendly);
        } else {
            System.out.printf("Added: %s (%s) -> FAILED (Roster Full)%n", emp.getEmpName(), friendly);
        }
    }
}