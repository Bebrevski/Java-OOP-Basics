package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();

        String[] inputPeople = reader.readLine().split(";");
        if (collectPersonData(people, inputPeople)) return;


        Map<String, Product> products = new LinkedHashMap<>();

        String[] inputProducts = reader.readLine().split(";");
        collectProductsData(products, inputProducts);


        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            try {
                people.get(personName).addProduct(products.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, Person> personEntry : people.entrySet()) {
            System.out.println(personEntry.getValue());
        }

    }

    private static boolean collectPersonData(Map<String, Person> people, String[] inputPeople) {
        for (String person : inputPeople) {
            String[] tokens = person.split("=");
            String personName = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            try {
                Person currentPerson = new Person(personName, money);
                people.put(personName, currentPerson);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return true;
            }
        }
        return false;
    }

    private static void collectProductsData(Map<String, Product> products, String[] inputProducts) {
        for (String inputProduct : inputProducts) {
            String[] tokens = inputProduct.split("=");
            String productName = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            try {
                Product product = new Product(productName, price);
                products.put(productName, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
    }
}
