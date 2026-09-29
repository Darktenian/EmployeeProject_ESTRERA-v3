package version1;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Hourly Employee Test ---");


        HourlyEmployee hourly1 = new HourlyEmployee(101, "Alice Smith");
        hourly1.setTotalHoursWorked(45.0f);
        hourly1.setRatePerHour(200.0);
        hourly1.displayHourlyEmployee();
        System.out.println(hourly1);

        HourlyEmployee hourly2 = new HourlyEmployee(102, "Bob Johnson", 38.0f, 250.0);
        hourly2.displayHourlyEmployee();
        System.out.println(hourly2);

        HourlyEmployee hourly3 = new HourlyEmployee();
        hourly3.setEmpID(103);
        hourly3.setEmpName("Henry Gold");
        hourly3.setTotalHoursWorked(50.0f);
        hourly3.setRatePerHour(180.0);
        System.out.printf("Read back: ID=%d Name=%s Hours=%.2f Rate=%.2f%n",
                hourly3.getEmpID(), hourly3.getEmpName(),
                hourly3.getTotalHoursWorked(), hourly3.getRatePerHour());
        hourly3.displayHourlyEmployee();
        System.out.println(hourly3);

        System.out.println("\n--- Piece Worker Employee Test ---");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201, "Bob Jones");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.0);
        piece1.displayPieceWorkerEmployee();
        System.out.println(piece1);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, "Carol White", 150, 20.0);
        piece2.displayPieceWorkerEmployee();
        System.out.println(piece2);

        PieceWorkerEmployee piece3 = new PieceWorkerEmployee();
        piece3.setEmpID(203);
        piece3.setEmpName("Ivy Rose");
        piece3.setTotalPiecesFinished(320);
        piece3.setRatePerPiece(12.5);
        System.out.printf("Read back: ID=%d Name=%s Pieces=%d Rate=%.2f%n",
                piece3.getEmpID(), piece3.getEmpName(),
                piece3.getTotalPiecesFinished(), piece3.getRatePerPiece());
        piece3.displayPieceWorkerEmployee();
        System.out.println(piece3);

        System.out.println("\n--- Commission Employee Test ---");

        CommissionEmployee comm1 = new CommissionEmployee(301, "David Brown");
        comm1.setTotalSale(75000.0);
        comm1.displayCommissionEmployee();
        System.out.println(comm1);


        CommissionEmployee comm2 = new CommissionEmployee(302, "Eve Green", 200000.0);
        comm2.displayCommissionEmployee();
        System.out.println(comm2);

        CommissionEmployee comm3 = new CommissionEmployee();
        comm3.setEmpID(303);
        comm3.setEmpName("Jack Tan");
        comm3.setTotalSale(45000.0);
        System.out.printf("Read back: ID=%d Name=%s Sale=%.2f%n",
                comm3.getEmpID(), comm3.getEmpName(), comm3.getTotalSale());
        comm3.displayCommissionEmployee();
        System.out.println(comm3);

        System.out.println("\n--- Base Plus Commission Employee Test ---");


        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401, "Frank Black");
        base1.setTotalSale(120000.0);
        base1.setBaseSalary(5000.0);
        base1.displayBasePlusCommissionEmployee();
        System.out.println(base1);

        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee(402, "Grace Blue", 600000.0, 8000.0);
        base2.displayBasePlusCommissionEmployee();
        System.out.println(base2);

        BasePlusCommissionEmployee base3 = new BasePlusCommissionEmployee();
        base3.setEmpID(403);
        base3.setEmpName("Kim Lee");
        base3.setTotalSale(800000.0);
        base3.setBaseSalary(10000.0);
        System.out.printf("Read back: ID=%d Name=%s Sale=%.2f Base=%.2f%n",
                base3.getEmpID(), base3.getEmpName(),
                base3.getTotalSale(), base3.getBaseSalary());
    }
}