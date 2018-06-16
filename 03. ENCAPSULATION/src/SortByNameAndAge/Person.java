package SortByNameAndAge;

class Person {
    private String FirstName;
    private String LastName;
    private Integer Age;

    Person(String firstName, String lastName, Integer age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }

    String getFirstName() {
        return FirstName;
    }

    String getLastName() {
        return LastName;
    }

    Integer getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old."
                , this.getFirstName()
                , this.getLastName()
                , this.getAge());
    }
}
