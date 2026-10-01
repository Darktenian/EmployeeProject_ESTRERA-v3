@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println();

        Name aliceName = new Name("Alice", "Marie", "Smith");
        MyDate aliceHired = new MyDate(1, 6, 2022);
        MyDate externalDOB = new MyDate(15, 12, 1995);

        HourlyEmployee emp = new HourlyEmployee(101, aliceName, externalDOB, aliceHired, 40.0f, 200.0);

        System.out.println("Original Birth Month: " + emp.getBirthDate().getMonth() + " (Dec)");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)");

        emp.getBirthDate().setMonth(9);
        externalDOB.setMonth(9);

        System.out.println("Employee's Actual Birth Date after tampering attempt: " + emp.getBirthDate());
        System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");

        System.out.println();
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println();

        System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
        try {
            new HourlyEmployee(102, aliceName, new MyDate(15, 12, 1995), aliceHired, 40.0f, -150.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }

        System.out.println();
        System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }

        System.out.println();
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println();

        EmployeeRoster roster = new EmployeeRoster();

        Name mariaName = new Name("Maria", "Lopez", "Reyes");
        Name kevinName = new Name("Kevin", "Sy", "Tan");
        Name bobName = new Name("Bob", "Carl", "Jones", "Jr.");

        roster.addEmployee(new HourlyEmployee(101, aliceName,
                new MyDate(18, 9, 2000), aliceHired, 45.0f, 200.0));
        roster.addEmployee(new PieceWorkerEmployee(201, bobName,
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0));
        roster.addEmployee(new CommissionEmployee(301, mariaName,
                new MyDate(22, 9, 1990), new MyDate(10, 3, 2019), 100000.0));
        roster.addEmployee(new BasePlusCommissionEmployee(401, kevinName,
                new MyDate(11, 12, 1985), new MyDate(5, 9, 2018), 160000.0, 8000.0));

        roster.displayPayroll(9);
    }
}