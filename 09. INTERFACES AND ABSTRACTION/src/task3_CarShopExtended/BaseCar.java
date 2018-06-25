package task3_CarShopExtended;

public abstract class BaseCar implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public BaseCar(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {

        return String.format("%s is %s and have %d horse powers"
                , this.getModel()
                , this.getColor()
                , this.getHorsePower()) +
                System.lineSeparator() +
                String.format("This is %s produced in %s and have %d tires"
                        , this.getModel()
                        , this.countryProduced
                        , TIRES);
    }
}
