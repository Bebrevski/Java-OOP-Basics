package task2_VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumation, double tankCapacity) {
        super(fuelQuantity, fuelConsumation, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelNeeded = (super.getFuelConsumation() + Constants.TRUCK_AIR_CONDITION_CONSUMATION) * distance;
        if (fuelNeeded > super.getFuelQuantity()) {
            throw new IllegalArgumentException(Constants.TRUCK_NEEDS_REFUELING);
        }

        this.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
    }

    @Override
    public void refuel(double liters) {
        super.checkLiters(liters * 0.95);
        super.setFuelQuantity(liters * 0.95 + super.getFuelQuantity());
    }
}
