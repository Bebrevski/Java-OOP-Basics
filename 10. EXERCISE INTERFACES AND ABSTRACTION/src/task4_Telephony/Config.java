package task4_Telephony;

import java.util.regex.Pattern;

class Config {
    static final Pattern PHOENUMBER_PATTERN = Pattern.compile("[a-zA-Z]+");
    static final String INVALID_PHONENUMBER = "Invalid number!";
    static final String CALLING_NUMBER = "Calling... %s";

    static final Pattern WEBSITE_PATTERN = Pattern.compile("[0-9]+");
    static final String INVALID_WEBSITE = "Invalid URL!";
    static final String BROWSING_WEBSITE = "Browsing: %s!";
}
