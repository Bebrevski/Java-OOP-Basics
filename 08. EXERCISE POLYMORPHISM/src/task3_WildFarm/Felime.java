package task3_WildFarm;

public abstract class Felime extends Mamal {
    public Felime() {
    }

    public Felime(String livingRegion) {
        super(livingRegion);
    }

    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
}
