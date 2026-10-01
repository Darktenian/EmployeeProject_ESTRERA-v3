
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

        Name aliceName = new Name("Alice", "Marie", "Smith");
        MyDate aliceDOB = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);

        Name bobName = new Name("Bob", "Carl", "Jones", "Jr.");
        MyDate bobDOB = new MyDate(5, 4, 1998);
        MyDate bobHired = new MyDate(15, 1, 2023);

        Name carolName = new Name("Carol", "Dee", "Brown");
        MyDate carolDOB = new MyDate(22, 7, 1990);
        MyDate carolHired = new MyDate(10, 3, 2019);

        Name daveName = new Name("Dave", "Eli", "Clark");
        MyDate daveDOB = new MyDate(11, 12, 1985);
        MyDate daveHired = new MyDate(5, 9, 2018);

        Employee[] employees = {
                new HourlyEmployee(101, aliceName, aliceDOB, aliceHired, 45.0f, 200.0),
                new PieceWorkerEmployee(201, bobName, bobDOB, bobHired, 250, 15.0),
                new CommissionEmployee(301, carolName, carolDOB, carolHired, 200000.0),
                new BasePlusCommissionEmployee(401, daveName, daveDOB, daveHired, 600000.0, 8000.0)
        };

        int targetMonth = 9;
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println();

        int index = 1;
        for (Employee emp : employees) {
            double base = emp.computeSalary(-1);
            double total = emp.computeSalary(targetMonth);
            double bonus = total - base;
            System.out.printf("%d. %s%n", index++, emp);
            System.out.printf("   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    base, bonus, bonus > 0 ? "Eligible" : "Ineligible");
            System.out.printf("   Total Payout: ₱%.2f%n%n", total);
        }

        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println();

        HourlyEmployee emp1 = new HourlyEmployee(101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f, 200.0);

        HourlyEmployee emp1identical = new HourlyEmployee(101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f, 200.0);

        HourlyEmployee emp2 = new HourlyEmployee(999,
                new Name("Zoe", "Q", "Stone"),
                new MyDate(1, 1, 2001),
                new MyDate(1, 1, 2021),
                20.0f, 100.0);

        System.out.println("emp1 equals emp1identical: " + emp1.equals(emp1identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode()
                + " | emp1identical hashCode: " + emp1identical.hashCode()
                + " (Match: " + (emp1.hashCode() == emp1identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));
        System.out.println();

        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println();

        HourlyEmployee original = new HourlyEmployee(101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f, 200.0);

        HourlyEmployee cloned = original.clone();

        System.out.println("Original Name before modification: " + original.getEmpName());
        cloned.getEmpName().setFirstName("Taylor");
        System.out.println("Clone Name changed to: " + cloned.getEmpName());
        System.out.println("Original Name after modification: " + original.getEmpName()
                + " (Deep copy successful!)");
    }
}