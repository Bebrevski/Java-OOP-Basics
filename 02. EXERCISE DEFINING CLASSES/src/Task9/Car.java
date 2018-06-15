package Task9;

class Car {
    private String Model;
    private int Speed;

    Car(String model, int speed) {
        Model = model;
        Speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Car:%n%s %d%n"
                , this.Model
                , this.Speed);
    }
}
