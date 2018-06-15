package Task9;

class Company {
    private String Name;
    private String Department;
    private double Salary;

    Company(String name, String department, double salary) {
        Name = name;
        Department = department;
        Salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Company:%n%s %s %.2f%n"
        ,this.Name
        ,this.Department
        ,this.Salary);
    }
}
