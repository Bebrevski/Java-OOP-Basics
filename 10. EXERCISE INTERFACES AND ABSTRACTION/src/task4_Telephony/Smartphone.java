package task4_Telephony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Smartphone implements Call, Browse {

    private List<String> numbers;
    private List<String> website;

    public Smartphone() {
    }

    public Smartphone(List<String> numbers, List<String> website) {
        this.setNumbers(numbers);
        this.setWebsite(website);
    }

    public List<String> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers = numbers;
    }

    public List<String> getWebsite() {
        return Collections.unmodifiableList(this.website);
    }

    private void setWebsite(List<String> website) {
        this.website = new ArrayList<>();
        this.website = website;
    }

    @Override
    public String browsing(String website) {

        if (Config.WEBSITE_PATTERN.matcher(website).find()) {
            throw new IllegalArgumentException(Config.INVALID_WEBSITE);
        }

        return String.format(Config.BROWSING_WEBSITE, website);
    }

    @Override
    public String calling(String number) {

        if (Config.PHOENUMBER_PATTERN.matcher(number).find()) {
            throw new IllegalArgumentException(Config.INVALID_PHONENUMBER);
        }

        return String.format(Config.CALLING_NUMBER, number);
    }
}
