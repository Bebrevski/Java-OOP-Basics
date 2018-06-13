package Task1_2_3;

class Person {
    private String Name;
    private int Age;

    Person() {
        this("No name", 1);
    }

    Person(int age) {
        this("No name", age);
    }

    Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    String getName() {
        return Name;
    }

    void setName(String name) {
        Name = name;
    }

    int getAge() {
        return Age;
    }

    void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d"
                , this.getName()
                , this.getAge());
    }

    public String printMethodForOpinionPollTask() {
        return String.format("%s - %d"
                , this.getName()
                , this.getAge());
    }
}