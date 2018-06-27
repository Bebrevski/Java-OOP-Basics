package task7_FoodShortage;

public interface Buyer {
    int FOOD_FOR_CITIZEN = 10;
    int FOOD_FOR_REBELIAN = 5;

    void buyFood();

    int getFood();
}
