package task4_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> websites = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        Smartphone phone = new Smartphone(numbers, websites);

        makeCalls(phone);

        browseWebsites(phone);
    }

    private static void browseWebsites(Smartphone phone) {
        for (String website : phone.getWebsite()) {
            try {
                System.out.println(phone.browsing(website));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void makeCalls(Smartphone phone) {
        for (String number : phone.getNumbers()) {
            try {
                System.out.println(phone.calling(number));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
