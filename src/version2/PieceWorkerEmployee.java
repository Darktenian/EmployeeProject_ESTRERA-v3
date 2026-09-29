@SuppressWarnings("unused")
public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    private static final double BIRTHDAY_BONUS = 5000.00;


    public PieceWorkerEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate,
                               MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }


    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) {
        this.empName = (empName == null) ? new Name() : empName;
    }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) {
        this.birthDate = (birthDate == null) ? new MyDate() : birthDate;
    }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) {
        this.dateHired = (dateHired == null) ? new MyDate() : dateHired;
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = (ratePerPiece < 0) ? 0 : ratePerPiece;
    }


    public double computeSalary() {
        return computeSalary(-1);
    }

    public double computeSalary(int currentMonth) {
        double base = totalPiecesFinished * ratePerPiece;
        int hundreds = totalPiecesFinished / 100;
        double bonus = hundreds * (10 * ratePerPiece);
        double total = base + bonus;
        if (birthDate.getMonth() == currentMonth) {
            total += BIRTHDAY_BONUS;
        }
        return total;
    }


    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName.toString(), birthDate.toString(),
                dateHired.toString(), totalPiecesFinished, ratePerPiece, computeSalary());
    }
}