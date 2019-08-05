package by.zapolski.week01.task1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneNumber {

    public static String getPhoneNumberFromListWithoutRegExp(List<Integer> numbers){
        checkList(numbers);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            switch (i){
                case 0:
                    sb.append('(');
                    break;
                case 3:{
                    sb.append(") ");
                    break;
                }
                case 6:{
                    sb.append('-');
                    break;
                }
            }
            sb.append(numbers.get(i));
        }

        return sb.toString();
    }

    public static String getPhoneNumberFromListWithRegExp(List<Integer> numbers) {
        checkList(numbers);

        String result = numbers.stream().map(Object::toString)
                .collect(Collectors.joining(""));

        Pattern p = Pattern.compile("([\\d]{3})([\\d]{3})([\\d]{4})"); // Create the pattern.
        Matcher matcher = p.matcher(result); // Create the matcher.

        if (matcher.find()){
            result = "("+matcher.group(1)+") "+matcher.group(2)+"-"+matcher.group(3);
        }

        return result;
    }

    private static void checkList(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 10){
            throw new IllegalArgumentException("List size is incorrect (list null or not contains 10 items.");
        }
    }

}
