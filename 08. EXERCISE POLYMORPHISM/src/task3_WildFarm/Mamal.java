package task3_WildFarm;

import java.text.DecimalFormat;

public abstract class Mamal extends Animal {

    private String livingRegion;

    protected static final DecimalFormat format = new DecimalFormat("#.##");

    public Mamal() {
    }

    public Mamal(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public Mamal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]"
                , this.getClass().getSimpleName()
                , super.getAnimalName()
                , format.format(super.getAnimalWeight())
                , this.getLivingRegion()
                , super.getFoodEaten());
    }
}
