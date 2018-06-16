package SalaryIncrease;

import java.text.DecimalFormat;

class Person {
    private String FirstName;
    private String LastName;
    private Integer Age;
    private double Salary;
    private DecimalFormat format;

    Person() {
        this.format = new DecimalFormat("#.0############################################");
    }

    Person(String firstName, String lastName, Integer age, Double salary) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private String getFirstName() {
        return FirstName;
    }

    private void setFirstName(String firstName) {
        FirstName = firstName;
    }

    private String getLastName() {
        return LastName;
    }

    private void setLastName(String lastName) {
        LastName = lastName;
    }

    private Integer getAge() {
        return Age;
    }

    private void setAge(Integer age) {
        Age = age;
    }

    private double getSalary() {
        return Salary;
    }

    private void setSalary(double salary) {
        Salary = salary;
    }

    void increaseSalary(Double percent) {
        if (this.getAge() <= 30) {
            this.setSalary(this.getSalary() * (1 + percent / 200));
        } else {
            this.setSalary(this.getSalary() * (1 + percent / 100));
        }
    }



    @Override
    public String toString() {
        return String.format("%s %s gets %s leva"
                , this.getFirstName()
                , this.getLastName()
                , this.format.format(this.getSalary()));
    }
}
