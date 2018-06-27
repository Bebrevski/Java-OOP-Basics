package task7_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final String END_OF_LINES = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> record = new HashMap<>();

        int persons = Integer.parseInt(reader.readLine());
        for (int i = 0; i < persons; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthdate = tokens[3];

                record.put(name, new Citizen(name, age, id, birthdate));
            } else if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];

                record.put(name, new Rebel(name, age, group));
            }
        }

        String input;
        while (!END_OF_LINES.equals(input = reader.readLine())) {
            if (record.containsKey(input)) {
                record.get(input).buyFood();
            }
        }

        int result = 0;
        for (Buyer buyer : record.values()) {
            result += buyer.getFood();
        }

        System.out.println(result);
    }
}