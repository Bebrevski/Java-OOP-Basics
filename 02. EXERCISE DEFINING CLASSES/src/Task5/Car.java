package Task5;

class Car {
    private String Model;
    private double FuelAmount;
    private double FuelCostPerKilometer;
    private int Distance;
    private double PossibleDistance;
    private String Result;

    Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.Model = model;
        this.FuelAmount = fuelAmount;
        this.FuelCostPerKilometer = fuelCostPerKilometer;

        this.Distance = 0;
        this.setPossibleDistance();
        this.Result = "";
    }

    private void setPossibleDistance() {
        PossibleDistance = this.FuelAmount / this.FuelCostPerKilometer;
    }

    double getPossibleDistance() {
        return PossibleDistance;
    }

    void drive(int kilometers) {
        this.Distance += kilometers;
        this.FuelAmount -= kilometers * this.FuelCostPerKilometer;

        this.Result = String.format("%s %.2f %d%n"
                , this.Model
                , this.FuelAmount
                , this.Distance);

        setPossibleDistance();
    }

    @Override
    public String toString() {
        if (this.Result.equals("")) {
            return String.format("%s %.2f %d%n"
                    , this.Model
                    , this.FuelAmount
                    , this.Distance);
        }

        return this.Result;
    }
}
