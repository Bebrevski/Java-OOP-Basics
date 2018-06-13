package Task1_2_3;

import java.lang.reflect.Field;

public class Task1 {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
