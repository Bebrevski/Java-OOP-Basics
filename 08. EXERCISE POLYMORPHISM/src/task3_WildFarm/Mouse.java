package task3_WildFarm;

public class Mouse extends Mamal {

    private static final String MAKE_SOUND = "SQUEEEAAAK!";
    private static final String REJECTED_FOOD = "Mice are not eating that type of food!";

    public Mouse() {
    }

    public Mouse(String livingRegion) {
        super(livingRegion);
    }

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return MAKE_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException(REJECTED_FOOD);
        }
    }
}
