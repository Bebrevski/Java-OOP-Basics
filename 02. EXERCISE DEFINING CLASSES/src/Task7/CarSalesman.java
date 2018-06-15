package Task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();

        int engineLines = Integer.parseInt(reader.readLine());
        addEngines(reader, engines, engineLines);

        List<Car> cars = new ArrayList<>();

        int carLines = Integer.parseInt(reader.readLine());
        addCars(reader, engines, cars, carLines);

        cars.forEach(System.out::println);
    }

    private static void addCars(BufferedReader reader, Map<String, Engine> engines, List<Car> cars, int carLines) throws IOException {
        for (int i = 0; i < carLines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];

            int weight = -1;
            String color = "n/a";

            if (tokens.length == 3) {
                try {
                    weight = Integer.parseInt(tokens[2]);
                } catch (Exception ex) {
                    color = tokens[2];
                }
            } else if (tokens.length == 4) {
                weight = Integer.parseInt(tokens[2]);
                color = tokens[3];
            }

            cars.add(new Car(model, engines.get(engine), weight, color));
        }
    }

    private static void addEngines(BufferedReader reader, Map<String, Engine> engines, int engineLines) throws IOException {
        for (int i = 0; i < engineLines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            int displacement = -1;
            String efficiency = "n/a";

            if (tokens.length == 3) {
                try {
                    displacement = Integer.parseInt(tokens[2]);
                } catch (Exception ex) {
                    efficiency = tokens[2];
                }
            } else if (tokens.length == 4) {
                displacement = Integer.parseInt(tokens[2]);
                efficiency = tokens[3];
            }

            Engine currentEngine = new Engine(model, power, displacement, efficiency);
            engines.putIfAbsent(model, currentEngine);
        }
    }
}
