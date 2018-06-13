import java.lang.reflect.Field;

public class Task1 {
    // Task 1 - Define Class Person

    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
