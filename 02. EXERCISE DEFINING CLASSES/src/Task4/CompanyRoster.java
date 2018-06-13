package Task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Department> record = new HashMap<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split(" ");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            String email = "n/a";
            int age = -1;

            if (tokens.length == 5) {
                String unknown = tokens[4];
                try {
                    age = Integer.parseInt(unknown);
                } catch (Exception ex) {
                    email = unknown;
                }
            } else if (tokens.length == 6){
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
            }

            Employee currentEmployee = new Employee(name, salary, position, department, email, age);

            record.putIfAbsent(department, new Department(department));
            record.get(department).addEmployees(currentEmployee);
        }

        StringBuilder sb = new StringBuilder();

        record.entrySet().stream()
                .sorted((d1, d2) -> {
                    double d1Average = d1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double d2Average = d2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    return Double.compare(d2Average, d1Average);
                })
                .limit(1)
                .forEach(d -> {
                    sb.append("Highest Average Salary: ").append(d.getKey()).append(System.lineSeparator());

                    d.getValue().getEmployees().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> sb
                                    .append(String.format("%s %.2f %s %d"
                                            , e.getName()
                                            , e.getSalary()
                                            , e.getEmail()
                                            , e.getAge()))
                                    .append(System.lineSeparator()));
                });

        System.out.println(sb);
    }
}

