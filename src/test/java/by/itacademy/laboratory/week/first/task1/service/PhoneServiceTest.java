package by.itacademy.laboratory.week.first.task1.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PhoneServiceTest {

    private PhoneService phoneService = new PhoneService();

    @Test
    public void checkDefaultHandling() {
        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        String actualPhone = phoneService.handleDefault(digits);

        assertNotNull(actualPhone);
        final String expectedPhone = "(012) 345-6789";
        assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void checkRegexHandling() {
        List<Integer> digits = Arrays.asList(4, 5, 6, 7, 8, 9, 0, 1, 2, 3);
        String actualPhone = phoneService.handleByRegex(digits);

        assertNotNull(actualPhone);
        final String expectedPhone = "(456) 789-0123";
        assertEquals(expectedPhone, actualPhone);
    }
}
