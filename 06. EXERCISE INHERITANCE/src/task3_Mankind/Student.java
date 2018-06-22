package task3_Mankind;

public class Student extends Human {
    private static final String INVALID_FACULTY_NUMBER = "Invalid faculty number!";

    private String FacultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return this.FacultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }
        this.FacultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append("First Name: ").append(super.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName()).append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacultyNumber());

        return sb.toString();
    }
}
