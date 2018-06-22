package task1_Person;

class Person {
    private Integer Age;
    private String Name;

    Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    Integer getAge() {
        return this.Age;
    }

    protected void setAge(int age) throws IllegalArgumentException {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.Age = age;
    }

    String getName() {
        return this.Name;
    }

    protected void setName(String name) throws IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.Name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d"
        ,this.getName()
        ,this.getAge());
    }
}
