package task6_BirthdayCelebrations;

public class Pet implements CitizenBase{
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate(String year) {
        if (this.birthdate.endsWith(year)) {
            return this.birthdate;
        }

        throw new IllegalArgumentException();
    }
}
