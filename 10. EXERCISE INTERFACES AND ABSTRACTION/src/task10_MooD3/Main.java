package task10_MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = input.readLine().split("\\s+\\|\\s+");
        String username = tokens[0];
        String type = tokens[1];
        int level = Integer.parseInt(tokens[3]);

        Base base = null;
        switch (type) {
            case "Demon":
                double specialPoints = Double.parseDouble(tokens[2]);
                base = new Demon(username, specialPoints, level);

                break;
            case "Archangel":
                int mana = Integer.parseInt(tokens[2]);
                base = new Archangel(username, mana, level);

                break;
        }

        System.out.println(base);
    }
}
