package task2_VehiclesExtension;

public abstract class BusAbstract extends Vehicle {
    public BusAbstract(double fuelQuantity, double fuelConsumation, double tankCapacity) {
        super(fuelQuantity, fuelConsumation, tankCapacity);
    }

    public abstract void driveEmpty( double distance);
}
