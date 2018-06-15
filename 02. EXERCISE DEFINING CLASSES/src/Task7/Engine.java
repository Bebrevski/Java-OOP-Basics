package Task7;

class Engine {
    private String Model;
    private int Power;
    private int Displacement;
    private String Efficiency;

    Engine(String model, int power, int displacement, String efficiency) {
        this.Model = model;
        this.Power = power;
        this.Displacement = displacement;
        this.Efficiency = efficiency;
    }

    String getModel() {
        return Model;
    }

    int getPower() {
        return Power;
    }

    int getDisplacement() {
        return Displacement;
    }

    String getEfficiency() {
        return Efficiency;
    }
}
