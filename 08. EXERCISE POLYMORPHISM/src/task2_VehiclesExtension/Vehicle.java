package task2_VehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumation;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumation, double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumation(fuelConsumation);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.checkLiters(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumation() {
        return this.fuelConsumation;
    }

    public void setFuelConsumation(double fuelConsumation) {
        this.fuelConsumation = fuelConsumation;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void checkLiters(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException(Constants.FUEL_MUST_BE_POSITIVE_NUMBER);
        }
        if (liters + this.getFuelQuantity() > this.getTankCapacity()) {
            throw new IllegalArgumentException(Constants.CANNOT_FIT_FUEL_IN_TANK);
        }
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
