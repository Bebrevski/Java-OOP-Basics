package task1_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat FORMAT = new DecimalFormat("####.##");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carCuelConsumation = Double.parseDouble(carInfo[2]);

        Vehicle car = new Car(carFuelQuantity, carCuelConsumation);

        String[] truckInfo = reader.readLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumation = Double.parseDouble(truckInfo[2]);

        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumation);

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split(" ");
            String output = null;

            try {
                output = start(car, truck, tokens);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            if(output != null) {
                System.out.println(output);
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static String start(Vehicle car, Vehicle truck, String[] tokens) {
        String command = tokens[0];
        String vehicle = tokens[1];

        switch (command) {
            case "Drive":
                double distance = Double.parseDouble(tokens[2]);
                drive(car, truck,vehicle, distance);
                return String.format("%s travelled %s km", vehicle, FORMAT.format(distance));
            case "Refuel":
                double liters = Double.parseDouble(tokens[2]);
                refuel(car, truck, vehicle, liters);
        }

        return null;
    }

    private static void refuel(Vehicle car, Vehicle truck, String vehicle, double liters) {
        switch (vehicle){
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
        }
    }

    private static void drive(Vehicle car, Vehicle truck, String vehicle, double distance) {
        switch (vehicle) {
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
        }
    }
}
