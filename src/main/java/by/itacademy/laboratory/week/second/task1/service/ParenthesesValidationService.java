package by.itacademy.laboratory.week.second.task1.service;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesValidationService {

    public boolean isValid(String value) {
        boolean result = true;
        final String openBrackets = "({[";
        final String closeBrackets = ")}]";

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < value.length(); i++) {
            char currentChar = value.charAt(i);
            if (openBrackets.indexOf(currentChar) != -1) {
                deque.add(currentChar);
            } else {
                if (deque.isEmpty() || openBrackets.charAt(closeBrackets.indexOf(currentChar)) != deque.pollLast()) {
                    result = false;
                    break;
                }
            }
        }
        if (!deque.isEmpty()) {
            result = false;
        }

        return result;
    }
}
