package task2_VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumation, double tankCapacity) {
        super(fuelQuantity, fuelConsumation, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelNeeded = (super.getFuelConsumation() + Constants.CAR_AIR_CONDITION_CONSUMATION) * distance;
        if (fuelNeeded > super.getFuelQuantity()) {
            throw new IllegalArgumentException(Constants.CAR_NEEDS_REFUELING);
        }

        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
    }

    @Override
    public void refuel(double liters) {
        super.checkLiters(liters);
        super.setFuelQuantity(liters + super.getFuelQuantity());
    }
}
