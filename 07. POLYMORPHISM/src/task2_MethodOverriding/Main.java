package task2_MethodOverriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Rectangle> rectangles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double[] sides = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            if (sides.length == 1) {
                rectangles.add(new Square(sides[0]));
            } else {
                rectangles.add(new Rectangle(sides[0], sides[1]));
            }
        }

        rectangles.forEach(r -> System.out.printf("%.1f%n", r.getArea()));
    }
}
