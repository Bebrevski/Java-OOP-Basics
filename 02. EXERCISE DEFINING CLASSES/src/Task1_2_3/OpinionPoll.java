package Task1_2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> record = new ArrayList<>();

        int countOfLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < countOfLines; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person currentPerson = new Person(name, age);

            record.add(currentPerson);
        }

        record.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.printMethodForOpinionPollTask()));
    }
}
