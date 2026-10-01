@SuppressWarnings("unused")
public final class Name implements Cloneable {
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
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.firstName = firstName.trim();
    }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null || middleName.trim().isEmpty())
                ? "N/A" : middleName.trim();
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.lastName = lastName.trim();
    }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    public void displayName() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String mi = middleName.equals("N/A") || middleName.isBlank()
                ? "" : " " + middleName.charAt(0) + ".";
        String suf = suffix.isEmpty() ? "" : " " + suffix;
        return lastName + ", " + firstName + mi + suf;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name other = (Name) obj;
        return firstName.equals(other.firstName)
                && middleName.equals(other.middleName)
                && lastName.equals(other.lastName)
                && suffix.equals(other.suffix);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}