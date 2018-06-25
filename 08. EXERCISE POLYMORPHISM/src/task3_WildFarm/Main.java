package task3_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] animalTokens = input.split(" ");
            String[] foodTokens = reader.readLine().split(" ");

            String output = feed(animalTokens, foodTokens, animals);
            System.out.print(output);
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static String feed(String[] animalTokens, String[] foodTokens, List<Animal> animals) {
        String animalType = animalTokens[0];
        String animalName = animalTokens[1];
        double animalWeight = Double.parseDouble(animalTokens[2]);
        String livingRegion = animalTokens[3];

        String foodName = foodTokens[0];
        int foodQuantity = Integer.parseInt(foodTokens[1]);

        Food food = getFood(foodName, foodQuantity);

        switch (animalType) {
            case "Mouse":
                return createAnimal(animalName, animalType, animalWeight, livingRegion, new Mouse(), food, animals);
            case "Zebra":
                return createAnimal(animalName, animalType, animalWeight, livingRegion, new Zebra(), food, animals);
            case "Tiger":
                return createAnimal(animalName, animalType, animalWeight, livingRegion, new Tiger(), food, animals);
            case "Cat":
                String breed = animalTokens[4];
                Cat cat = new Cat(breed);
                return createAnimal(animalName, animalType, animalWeight, livingRegion, cat, food, animals);

        }

        return null;
    }

    private static String createAnimal(String animalName, String animalType, double animalWeight, String livingRegion, Mamal mamal, Food food, List<Animal> animals) {
        mamal.setAnimalName(animalName);
        mamal.setAnimalType(animalType);
        mamal.setLivingRegion(livingRegion);
        mamal.setAnimalWeight(animalWeight);

        StringBuilder sb = new StringBuilder();
        sb.append(mamal.makeSound()).append(System.lineSeparator());

        try {
            mamal.eat(food);
        } catch (IllegalArgumentException ex) {
            sb.append(ex.getMessage()).append(System.lineSeparator());
        }

        animals.add(mamal);

        return sb.toString();
    }

    private static Food getFood(String foodName, int foodQuantity) {
        switch (foodName) {
            case "Vegetable":
                return new Vegetable(foodQuantity);
            case "Meat":
                return new Meat(foodQuantity);
        }

        return null;
    }
}
