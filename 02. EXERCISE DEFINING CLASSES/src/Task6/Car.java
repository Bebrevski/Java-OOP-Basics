package Task6;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String Model;
    private Engine Engine;
    private Cargo Cargo;
    private List<Tire> Tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
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

    public Engine getEngine() {
        return Engine;
    }

    public void setEngine(Engine engine) {
        Engine = engine;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        Cargo = cargo;
    }

    public List<Tire> getTires() {
        return Tires;
    }

    public void setTires(List<Tire> tires) {
        Tires = tires;
    }
}
