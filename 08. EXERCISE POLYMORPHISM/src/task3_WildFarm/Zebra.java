package task3_WildFarm;

public class Zebra extends Mamal {

    private static final String MAKE_SOUND = "Zs";
    private static final String REJECTED_FOOD = "Zebra are not eating that type of food!";


    public Zebra() {
    }

    public Zebra(String livingRegion) {
        super(livingRegion);
    }

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return MAKE_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(food.getQuantity() + super.getFoodEaten());
        } else {
            throw new IllegalArgumentException(REJECTED_FOOD);
        }
    }
}
