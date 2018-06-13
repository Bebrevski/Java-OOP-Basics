package Task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> record = new LinkedHashMap<>();

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split(" ");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            double pressuret1 = Double.parseDouble(tokens[5]);
            int aget1 = Integer.parseInt(tokens[6]);
            double pressuret2 = Double.parseDouble(tokens[7]);
            int aget2 = Integer.parseInt(tokens[8]);
            double pressuret3 = Double.parseDouble(tokens[9]);
            int aget3 = Integer.parseInt(tokens[10]);
            double pressuret4 = Double.parseDouble(tokens[11]);
            int aget4 = Integer.parseInt(tokens[12]);


            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>() {{
                add(new Tire(pressuret1, aget1));
                add(new Tire(pressuret2, aget2));
                add(new Tire(pressuret3, aget3));
                add(new Tire(pressuret4, aget4));
            }};

            Car car = new Car(model, engine, cargo, tires);

            record.put(model, car);
        }

        String command = reader.readLine();

        if (command.equals("fragile")) {
            record.entrySet().stream()
                    .filter(c -> c.getValue()
                            .getCargo()
                            .getCargoType()
                            .equals("fragile"))
                    .filter(c -> c.getValue()
                            .getTires()
                            .stream()
                            .filter(t -> t.getTirePressure() < 1)
                            .collect(Collectors.toList()).size() > 0)
                    .forEach(c -> System.out.println(c.getKey()));
        } else {
            record.entrySet().stream()
                    .filter(c -> c.getValue()
                            .getCargo()
                            .getCargoType()
                            .equals("flamable"))
                    .filter(c -> c.getValue()
                            .getEngine()
                            .getEnginePower() > 250)
                    .forEach(c -> System.out.println(c.getKey()));
        }
    }
}

class Car {
    private String Model;
    private Engine Engine;
    private Cargo Cargo;
    private List<Tire> Tires;

    public Car(String model, Task6.Engine engine, Task6.Cargo cargo, List<Tire> tires) {
        if (Tires == null) {
            Tires = new ArrayList<>(4);
        }

        Model = model;
        Engine = engine;
        Cargo = cargo;
        Tires = tires;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Task6.Engine getEngine() {
        return Engine;
    }

    public void setEngine(Task6.Engine engine) {
        Engine = engine;
    }

    public Task6.Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Task6.Cargo cargo) {
        Cargo = cargo;
    }

    public List<Tire> getTires() {
        return Tires;
    }

    public void setTires(List<Tire> tires) {
        Tires = tires;
    }
}

class Engine {
    private int EngineSpeed;
    private int EnginePower;

    Engine(int engineSpeed, int enginePower) {
        EngineSpeed = engineSpeed;
        EnginePower = enginePower;
    }

    public int getEngineSpeed() {
        return EngineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        EngineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public void setEnginePower(int enginePower) {
        EnginePower = enginePower;
    }
}

class Cargo {
    private int CargoWeight;
    private String CargoType;

    public Cargo(int cargoWeight, String cargoType) {
        CargoWeight = cargoWeight;
        CargoType = cargoType;
    }

    public int getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        CargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }
}

class Tire {
    private double TirePressure;
    private int TireAge;

    public Tire(double tirePressure, int tireAge) {
        TirePressure = tirePressure;
        TireAge = tireAge;
    }

    public double getTirePressure() {
        return TirePressure;
    }

    public void setTirePressure(double tirePressure) {
        TirePressure = tirePressure;
    }

    public int getTireAge() {
        return TireAge;
    }

    public void setTireAge(int tireAge) {
        TireAge = tireAge;
    }
}
