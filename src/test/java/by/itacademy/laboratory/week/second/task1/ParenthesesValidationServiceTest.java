package by.itacademy.laboratory.week.second.task1;

import by.itacademy.laboratory.week.second.task1.service.ParenthesesValidationService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParenthesesValidationServiceTest {

    private ParenthesesValidationService parenthesesValidationService = new ParenthesesValidationService();

    @Test
    public void shouldBeValid() {
        final String value = "(){}[]";
        assertTrue(parenthesesValidationService.isValid(value));
    }

    @Test
    public void shouldBeValidEmptyString() {
        final String value = "";
        assertTrue(parenthesesValidationService.isValid(value));
    }

    @Test
    public void shouldBeNotValid() {
        final String value = "([)]";
        assertFalse(parenthesesValidationService.isValid(value));
    }
}