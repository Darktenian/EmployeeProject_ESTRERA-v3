
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

        // ===== Composition Verification =====
        System.out.println("--- Name & Date Verification ---");
        Name testName = new Name("Alice", "Marie", "Smith");
        MyDate testDate = new MyDate(18, 9, 2026);
        System.out.print("Name: ");
        testName.displayName();
        System.out.print("Date: ");
        testDate.displayDate();

        // Shared composition objects
        Name aliceName  = new Name("Alice", "Marie", "Smith");          // Sept birthday
        MyDate aliceDOB = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);

        Name bobName    = new Name("Bob", "Carl", "Jones", "Jr.");       // Oct birthday
        MyDate bobDOB   = new MyDate(5, 10, 1995);
        MyDate bobHired = new MyDate(15, 3, 2020);

        // ===== Hourly Employee =====
        System.out.println("\n--- Hourly Employee Payroll Test ---");

        HourlyEmployee h1 = new HourlyEmployee(101, aliceName, aliceDOB, aliceHired, 45.0f, 200.0);
        h1.displayHourlyEmployee();
        System.out.println(h1);
        System.out.printf("[Birthday Check] Regular Month (Oct) Salary: ₱%.2f%n", h1.computeSalary(10));
        System.out.printf("[Birthday Check] Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n", h1.computeSalary(9));

        HourlyEmployee h2 = new HourlyEmployee();
        h2.setEmpID(102);
        h2.setEmpName(bobName);
        h2.setBirthDate(bobDOB);
        h2.setDateHired(bobHired);
        h2.setTotalHoursWorked(38.0f);
        h2.setRatePerHour(250.0);
        h2.displayHourlyEmployee();
        System.out.println(h2);
        System.out.printf("[Birthday Check] Regular Month (Sep) Salary: ₱%.2f%n", h2.computeSalary(9));
        System.out.printf("[Birthday Check] Birth Month (Oct) Salary (+₱5,000.00): ₱%.2f%n", h2.computeSalary(10));

        // ===== Piece Worker Employee =====
        System.out.println("\n--- Piece Worker Employee Payroll Test ---");

        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, aliceName, aliceDOB, aliceHired, 250, 15.0);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);
        System.out.printf("[Birthday Check] Regular Month (Jan) Salary: ₱%.2f%n", p1.computeSalary(1));
        System.out.printf("[Birthday Check] Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n", p1.computeSalary(9));

        PieceWorkerEmployee p2 = new PieceWorkerEmployee();
        p2.setEmpID(202);
        p2.setEmpName(bobName);
        p2.setBirthDate(bobDOB);
        p2.setDateHired(bobHired);
        p2.setTotalPiecesFinished(150);
        p2.setRatePerPiece(20.0);
        p2.displayPieceWorkerEmployee();
        System.out.println(p2);
        System.out.printf("[Birthday Check] Birth Month (Oct) Salary (+₱5,000.00): ₱%.2f%n", p2.computeSalary(10));
        System.out.printf("[Birthday Check] Regular Month (Dec) Salary: ₱%.2f%n", p2.computeSalary(12));

        // ===== Commission Employee =====
        System.out.println("\n--- Commission Employee Payroll Test ---");

        CommissionEmployee c1 = new CommissionEmployee(301, aliceName, aliceDOB, aliceHired, 75000.0);
        c1.displayCommissionEmployee();
        System.out.println(c1);
        System.out.printf("[Birthday Check] Regular Month (Mar) Salary: ₱%.2f%n", c1.computeSalary(3));
        System.out.printf("[Birthday Check] Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n", c1.computeSalary(9));

        CommissionEmployee c2 = new CommissionEmployee();
        c2.setEmpID(302);
        c2.setEmpName(bobName);
        c2.setBirthDate(bobDOB);
        c2.setDateHired(bobHired);
        c2.setTotalSale(200000.0);
        c2.displayCommissionEmployee();
        System.out.println(c2);
        System.out.printf("[Birthday Check] Birth Month (Oct) Salary (+₱5,000.00): ₱%.2f%n", c2.computeSalary(10));
        System.out.printf("[Birthday Check] Regular Month (Feb) Salary: ₱%.2f%n", c2.computeSalary(2));

        // ===== Base Plus Commission Employee =====
        System.out.println("\n--- Base Plus Commission Employee Payroll Test ---");

        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(
                401, aliceName, aliceDOB, aliceHired, 120000.0, 5000.0);
        b1.displayBasePlusCommissionEmployee();
        System.out.println(b1);
        System.out.printf("[Birthday Check] Regular Month (Apr) Salary: ₱%.2f%n", b1.computeSalary(4));
        System.out.printf("[Birthday Check] Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n", b1.computeSalary(9));

        BasePlusCommissionEmployee b2 = new BasePlusCommissionEmployee();
        b2.setEmpID(402);
        b2.setEmpName(bobName);
        b2.setBirthDate(bobDOB);
        b2.setDateHired(bobHired);
        b2.setTotalSale(600000.0);
        b2.setBaseSalary(8000.0);
        b2.displayBasePlusCommissionEmployee();
        System.out.println(b2);
        System.out.printf("[Birthday Check] Birth Month (Oct) Salary (+₱5,000.00): ₱%.2f%n", b2.computeSalary(10));
        System.out.printf("[Birthday Check] Regular Month (Jul) Salary: ₱%.2f%n", b2.computeSalary(7));
    }
}