package task1_Vehicles;

public class Truck extends Vehicle {

    private static final double AIR_CONDITION_CONSUMATION = 1.6;
    private static final String CAR_NEEDS_REFUELING = "Truck needs refueling";

    public Truck(double fuelQuantity, double fuelConsumation) {
        super(fuelQuantity, fuelConsumation);
    }

    @Override
    protected void drive(double kilometersToDrive) {
        double fuelNeeded = (this.getFuelConsumation() + AIR_CONDITION_CONSUMATION) * kilometersToDrive;
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalArgumentException(CAR_NEEDS_REFUELING);
        }

        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
    }

    @Override
    protected void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters * 0.95);
    }
}
