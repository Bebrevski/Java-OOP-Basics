package task6_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String CITIZEN = "Citizen";
    private static final String PET = "Pet";
    private static final String END = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<CitizenBase> citizens = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String citizen = tokens[0];

            if (CITIZEN.equals(citizen)) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthdate = tokens[4];

                citizens.add(new Human(name, age, id, birthdate));
            } else if (PET.equals(citizen)) {
                String name = tokens[1];
                String birthdate = tokens[2];

                citizens.add(new Pet(name, birthdate));
            }
        }

        String year = reader.readLine();
        for (CitizenBase citizen : citizens) {
            try {
                System.out.println(citizen.getBirthdate(year));
            } catch (IllegalArgumentException ignored) { }
        }
    }
}
