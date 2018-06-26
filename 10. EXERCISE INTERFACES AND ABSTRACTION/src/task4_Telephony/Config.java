package task4_Telephony;

import java.util.regex.Pattern;

public class Config {
    public static final Pattern PHOENUMBER_PATTERN = Pattern.compile("[a-zA-Z]+");
    public static final String INVALID_PHONENUMBER = "Invalid number!";
    public static final String CALLING_NUMBER = "Calling... %s";

    public static final Pattern WEBSITE_PATTERN = Pattern.compile("[0-9]+");
    public static final String INVALID_WEBSITE = "Invalid URL!";
    public static final String BROWSING_WEBSITE = "Browsing: %s!";
}
