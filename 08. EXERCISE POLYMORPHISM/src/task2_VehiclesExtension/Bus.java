package task2_VehiclesExtension;

public class Bus extends BusAbstract {

    public Bus(double fuelQuantity, double fuelConsumation, double tankCapacity) {
        super(fuelQuantity, fuelConsumation, tankCapacity);
    }

    @Override
    public void driveEmpty(double distance) {
        double fuelNeeded = this.getFuelConsumation() * distance;
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalArgumentException(Constants.BUS_NEEDS_REFUELING);
        }

        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
    }


    @Override
    public void drive(double distance) {
        double fuelNeeded = (this.getFuelConsumation() + Constants.AIR_CONDITION_CONSUMATION) * distance;
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalArgumentException(Constants.BUS_NEEDS_REFUELING);
        }

        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
    }

    @Override
    public void refuel(double liters) {
        super.checkLiters(liters);
        super.setFuelQuantity(liters + super.getFuelQuantity());
    }
}
