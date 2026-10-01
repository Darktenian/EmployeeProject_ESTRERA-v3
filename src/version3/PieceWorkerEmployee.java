

import java.util.Objects;
@SuppressWarnings("unused")
public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        setTotalPiecesFinished(0);
        setRatePerPiece(0);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(0, totalPiecesFinished);
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = Math.max(0, ratePerPiece);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double base = totalPiecesFinished * ratePerPiece;
        int hundreds = totalPiecesFinished / 100;
        double bonus = hundreds * (10 * ratePerPiece);
        return base + bonus + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}