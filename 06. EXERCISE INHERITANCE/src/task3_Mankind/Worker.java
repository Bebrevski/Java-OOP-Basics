package task3_Mankind;

public class Worker extends Human {
    private static final String INVALID_WORKER_LAST_NAME = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY = "Expected value mismatch!Argument: weekSalary";
    private static final String INVALID_WORKING_HOURS = "Expected value mismatch!Argument: workHoursPerDay";

    private double Salary;
    private double WorkHours;

    public Worker(String firstName, String lastName, double salary, double workHours) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkHours(workHours);
    }

    public double getSalary() {
        return this.Salary;
    }

    public void setSalary(double salary) {
        if (salary <= 10D) {
            throw new IllegalArgumentException(INVALID_WEEK_SALARY);
        }
        this.Salary = salary;
    }

    public double getWorkHours() {
        return this.WorkHours;
    }

    public void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12) {
            throw new IllegalArgumentException(INVALID_WORKING_HOURS);
        }
        this.WorkHours = workHours;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException(INVALID_WORKER_LAST_NAME);
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {

        return String.format(
                "First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f"
                ,super.getFirstName()
                ,super.getLastName()
                , this.getSalary()
                , this.getWorkHours()
                , this.getSalary() / (this.getWorkHours() * 7)
        );
    }
}
