package task4_SayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(){{
            add(new Bulgarian("Pesho"));
            add(new European("Pesho"));
            add(new Chinese("Pesho"));
        }};

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}
