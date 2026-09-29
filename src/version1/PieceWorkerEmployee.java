package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, "N/A", 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this(empID, empName, 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        setEmpID(empID);
        setEmpName(empName);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    // Area for Getters & Setters :3
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece < 0 ? 0 : ratePerPiece;
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusGroups = totalPiecesFinished / 100; // floor division for complete hundreds
        double bonusPay = bonusGroups * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}