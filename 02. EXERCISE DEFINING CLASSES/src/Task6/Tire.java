package Task6;

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
