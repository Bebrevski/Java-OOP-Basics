package task5_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<CitizenBase> citizens = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                citizens.add(new CitizenHuman(name, age, id));
            } else {
                String model = tokens[0];
                String id = tokens[1];

                citizens.add(new CitizenRobot(model, id));
            }
        }

        String withFinalDigits = reader.readLine();

        for (CitizenBase citizen : citizens) {
            try {
                System.out.println(citizen.getId(withFinalDigits));
            } catch (IllegalArgumentException ignored) { }
        }
    }
}
