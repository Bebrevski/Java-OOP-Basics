package task6_BirthdayCelebrations;

public class Human implements CitizenBase {
    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Human(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
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
