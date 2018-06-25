package task3_WildFarm;

public class Tiger extends Felime {

    private static final String MAKE_SOUND = "ROAAR!!!";
    private static final String REJECTED_FOOD = "Tigers are not eating that type of food!";

    private String livingRegion;

    public Tiger() {
    }

    public Tiger(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public Tiger(String livingRegion, String livingRegion1) {
        super(livingRegion);
        this.livingRegion = livingRegion1;
    }

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion, String livingRegion1) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion1;
    }

    @Override
    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String makeSound() {
        return MAKE_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException(REJECTED_FOOD);
        }
    }
}
