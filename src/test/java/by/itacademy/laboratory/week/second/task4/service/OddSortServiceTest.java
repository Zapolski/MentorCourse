package by.itacademy.laboratory.week.second.task4.service;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class OddSortServiceTest {

    private OddSortService oddSortService = new OddSortService();

    @Test
    public void shouldSortOddValuesInArray() {
        int[] actualValues = {5, 3, 2, 8, 1, 4, 9, 10, 7};
        oddSortService.sort(actualValues);

        int[] expectedValues = {1, 3, 2, 8, 5, 4, 7, 10, 9};
        assertTrue(Arrays.equals(expectedValues, actualValues));
    }
}