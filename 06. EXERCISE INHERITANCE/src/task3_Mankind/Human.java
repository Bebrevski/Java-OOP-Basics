package task3_Mankind;

public class Human {
    private static final String INVALID_HUMAN_FIRST_NAME = "Expected upper case letter!Argument: firstName";
    private static final String INVALID_HUMAN_FIRST_NAME_LENGTH = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_HUMAN_LAST_NAME = "Expected upper case letter!Argument: lastName";
    private static final String INVALID_HUMAN_LAST_NAME_LENGTH = "Expected length at least 3 symbols!Argument: lastName";

    private String FirstName;
    private String LastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_HUMAN_FIRST_NAME);
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException(INVALID_HUMAN_FIRST_NAME_LENGTH);
        }
        this.FirstName = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_HUMAN_LAST_NAME);
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(INVALID_HUMAN_LAST_NAME_LENGTH);
        }
        this.LastName = lastName;
    }
}
