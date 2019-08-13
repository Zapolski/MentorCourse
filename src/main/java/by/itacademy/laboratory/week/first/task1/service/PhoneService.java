package by.itacademy.laboratory.week.first.task1.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneService {

    private static final String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";
    private static final String REGEX = "%d";

    public String handleDefault(List<Integer> digits) {
        return String.format(PHONE_FORMAT, digits.toArray());
    }

    public String handleByRegex(List<Integer> digits) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PHONE_FORMAT);
        StringBuffer stringBuffer = new StringBuffer();
        int digitIndex = 0;
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf(digits.get(digitIndex++)));
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }
}
