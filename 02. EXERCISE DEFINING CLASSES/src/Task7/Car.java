package Task7;

public class Car {
    private String Model;
    private Engine Engine;
    private int Weight;
    private String Color;

    Car(String model, Engine engine, int weight, String color) {
        this.Model = model;
        this.Engine = engine;
        this.Weight = weight;
        this.Color = color;
    }

    @Override
    public String toString() {
        String weight = this.Weight == -1 ? "n/a" : "" + this.Weight;
        String displacement = this.Engine.getDisplacement() == -1 ? "n/a" : "" + this.Engine.getDisplacement();

        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s"
                , this.Model
                , this.Engine.getModel()
                , this.Engine.getPower()
                , displacement
                , this.Engine.getEfficiency()
                , weight
                , this.Color);
    }
}
