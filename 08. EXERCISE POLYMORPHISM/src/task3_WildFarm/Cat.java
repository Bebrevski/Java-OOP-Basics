package task3_WildFarm;

public class Cat extends Felime {

    private static final String MAKE_SOUND = "Meowwww";

    private String breed;

    public Cat(String breed) {
        this.breed = breed;
    }

    public Cat(String livingRegion, String breed) {
        super(livingRegion);
        this.breed = breed;
    }

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return MAKE_SOUND;
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]"
                , this.getClass().getSimpleName()
                , super.getAnimalName()
                , this.breed
                , format.format(super.getAnimalWeight())
                , this.getLivingRegion()
                , super.getFoodEaten());
    }
}
