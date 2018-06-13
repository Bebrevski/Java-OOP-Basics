import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Department {
    private String department;
    private List<Employee> employees;

    Department(String dep) {
        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }

        this.setDepartment(dep);
    }

    String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    void addEmployees(Employee emp) {
        this.employees.add(emp);
    }

    List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
