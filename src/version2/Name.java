
@SuppressWarnings("unused")
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", "N/A", "N/A", "");
    }

    public Name(String firstName, String lastName) {
        this(firstName, "N/A", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = (firstName == null || firstName.isBlank()) ? "N/A" : firstName;
    }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null || middleName.isBlank()) ? "N/A" : middleName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = (lastName == null || lastName.isBlank()) ? "N/A" : lastName;
    }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    public void displayName() {
        System.out.println(this);   // ✅ no unnecessary toString()
    }

    @Override
    public String toString() {
        String mi = middleName.equals("N/A") || middleName.isBlank()
                ? "" : " " + middleName.charAt(0) + ".";
        String suf = suffix.isEmpty() ? "" : " " + suffix;
        return lastName + ", " + firstName + mi + suf;
    }
}