package SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person person = new Person(firstName, lastName, age, salary);

            people.add(person);
        }

        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }

    }
}
