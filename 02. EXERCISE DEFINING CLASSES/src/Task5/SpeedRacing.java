package Task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> record = new LinkedHashMap<>();

        int cars = Integer.parseInt(reader.readLine());
        for (int i = 0; i < cars; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCost);

            record.put(model, car);
        }

        StringBuilder sb = new StringBuilder();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            if (record.get(model).getPossibleDistance() < kilometers) {
                sb.append("Insufficient fuel for the drive").append(System.lineSeparator());
                input = reader.readLine();
                continue;
            }

            record.get(model).drive(kilometers);

            input = reader.readLine();
        }

        record.forEach((key, value) -> sb.append(value.toString()));

        System.out.println(sb);
    }
}

