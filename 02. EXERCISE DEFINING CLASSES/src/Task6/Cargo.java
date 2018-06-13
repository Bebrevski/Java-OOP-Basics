package Task6;

class Cargo {
    private int CargoWeight;
    private String CargoType;

    public Cargo(int cargoWeight, String cargoType) {
        CargoWeight = cargoWeight;
        CargoType = cargoType;
    }

    public int getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        CargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }
}
