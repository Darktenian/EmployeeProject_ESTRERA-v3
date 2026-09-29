package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "N/A";
    }
    public Name(String firstName, String lastName) {
        this.(firstName, "", lastName, "");
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = (firstName == null || firstName.trim().isEmpty()) ? "N/A" : firstName.trim();
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middeName) {
        this.middleName = (middeName == null) ? "" : middeName.trim();
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = (lastName == null || lastName.trim().isEmpty()) ? "N/A" : lastName.trim();
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }
    private String middleInitial() {
        if (middleName == null || middleName.trim().isEmpty() || middleName.equalsIgnoreCase("N/A")) {
            return "";
        }
        return middleName.substring(0, 1).toUpperCase() + ",";
    }
    public void displayName() {
        System.out.println(toString());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ").append(firstName);

        String mi = middleInitial();

    }
}
