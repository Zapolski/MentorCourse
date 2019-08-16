package by.itacademy.laboratory.week.second.task3.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MajoritySearchServiceTest {

    private MajoritySearchService majoritySearchService = new MajoritySearchService();

    @Test
    public void shouldReturn3() {
        List<Integer> items = Arrays.asList(3, 2, 3);
        Integer actualResult = majoritySearchService.findMajority(items);
        final Integer expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn2() {
        List<Integer> items = Arrays.asList(2, 2, 1, 1, 1, 2, 2);
        Integer actualResult = majoritySearchService.findMajority(items);
        final Integer expectedResult = 2;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn5() {
        List<Integer> items = Arrays.asList(1, 2, 3, 5, 6, 7, 7, 8, 5, 9, 5);
        Integer actualResult = majoritySearchService.findMajority(items);
        final Integer expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn9Optimal() {
        List<Integer> items = Arrays.asList(10, 9, 9, 9, 10);
        Integer actualResult = majoritySearchService.findMajorityOptimal(items);
        final Integer expectedResult = 9;
        assertEquals(expectedResult, actualResult);
    }
}