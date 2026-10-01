@SuppressWarnings("unused")
public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public static final double BIRTHDAY_BONUS = 5000.00;

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    public final int getEmpID() { return empID; }

    public Name getEmpName() { return empName.clone(); }
    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() { return birthDate.clone(); }
    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() { return dateHired.clone(); }
    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Hire date cannot be null");
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth) {
        return (birthDate.getMonth() == currentMonth) ? BIRTHDAY_BONUS : 0.0;
    }

    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return empID == other.empID;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(empID);
    }

    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = this.empName.clone();
            cloned.birthDate = this.birthDate.clone();
            cloned.dateHired = this.dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}