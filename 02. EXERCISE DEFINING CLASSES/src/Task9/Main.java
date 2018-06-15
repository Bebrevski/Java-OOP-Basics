package Task9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> record = new HashMap<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");

            String personName = tokens[0];
            record.putIfAbsent(personName, new Person());

            record.get(personName).setName(personName);

            collectData(record, tokens, personName);

            input = reader.readLine();
        }

        String outputName = reader.readLine();

        System.out.println(record.get(outputName));
    }

    private static void collectData(Map<String, Person> record, String[] tokens, String personName) {
        String property = tokens[1];

        if (property.equals("company")) {

            String companyName = tokens[2];
            String companyDepartment = tokens[3];
            double salary = Double.parseDouble(tokens[4]);

            Company company = new Company(companyName, companyDepartment, salary);
            record.get(personName).setCompany(company);

        } else if (property.equals("pokemon")) {

            String pokemonName = tokens[2];
            String pokemonType = tokens[3];

            Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
            record.get(personName).addPokemon(pokemon);

        } else if (property.equals("parents")) {

            String parentName = tokens[2];
            String parentBirthday = tokens[3];

            Parent parent = new Parent(parentName, parentBirthday);
            record.get(personName).addParent(parent);

        } else if (property.equals("children")) {

            String childName = tokens[2];
            String childBirthday = tokens[3];

            Child child = new Child(childName, childBirthday);
            record.get(personName).addChild(child);

        } else if (property.equals("car")) {

            String carModel = tokens[2];
            int carSpeed = Integer.parseInt(tokens[3]);

            Car car = new Car(carModel, carSpeed);
            record.get(personName).setCar(car);

        }
    }
}
