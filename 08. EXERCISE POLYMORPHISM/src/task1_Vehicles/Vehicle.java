package task1_Vehicles;

public abstract class Vehicle {
    private double FuelQuantity;
    private double FuelConsumation;

    public Vehicle(double fuelQuantity, double fuelConsumation) {
        this.FuelQuantity = fuelQuantity;
        this.FuelConsumation = fuelConsumation;
    }

    public double getFuelQuantity() {
        return this.FuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.FuelQuantity = fuelQuantity;
    }

    public double getFuelConsumation() {
        return this.FuelConsumation;
    }

    public void setFuelConsumation(double fuelConsumation) {
        this.FuelConsumation = fuelConsumation;
    }

    protected abstract void drive(double kilometersToDrive);

    protected abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
