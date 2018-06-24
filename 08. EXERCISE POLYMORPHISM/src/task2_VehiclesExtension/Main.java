package task2_VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carCuelConsumation = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);

        String[] truckInfo = reader.readLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumation = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);

        String[] busInfo = reader.readLine().split(" ");
        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busFuelConsumation = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);


        Vehicle car = new Car(carFuelQuantity, carCuelConsumation, carTankCapacity);
        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumation, truckTankCapacity);
        BusAbstract bus = new Bus(busFuelQuantity, busFuelConsumation, busTankCapacity);

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split(" ");

            String output = null;

            try {
                output = execute(car, truck, bus, tokens);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            if (output != null) {
                System.out.println(output);
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static String execute(Vehicle car, Vehicle truck, Vehicle bus, String[] tokens) {
        String command = tokens[0];
        String vehicle = tokens[1];

        double distance;
        switch (command) {
            case "Drive":
                distance = Double.parseDouble(tokens[2]);
                drive(vehicle, distance, car, truck, bus);
                return String.format("%s travelled %s km", vehicle, Constants.FORMAT.format(distance));
            case "DriveEmpty":
                distance = Double.parseDouble(tokens[2]);
                ((BusAbstract) bus).driveEmpty(distance);
                return String.format("%s travelled %s km", vehicle, Constants.FORMAT.format(distance));
            case "Refuel":
                double liters = Double.parseDouble(tokens[2]);
                refuel(vehicle, liters, car, truck, bus);
                return null;
        }

        return null;
    }

    private static void refuel(String vehicle, double liters, Vehicle car, Vehicle truck, Vehicle bus) {
        switch (vehicle) {
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
            case "Bus":
                bus.refuel(liters);
                break;
        }
    }

    private static void drive(String vehicle, double distance, Vehicle car, Vehicle truck, Vehicle bus) {
        switch (vehicle) {
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
            case "Bus":
                bus.drive(distance);
                break;
        }
    }
}
