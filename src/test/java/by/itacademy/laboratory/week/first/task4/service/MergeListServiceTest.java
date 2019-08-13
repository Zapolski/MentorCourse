package by.itacademy.laboratory.week.first.task4.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MergeListServiceTest {

    private MergeListService mergeListService = new MergeListService();

    @Test
    public void checkTwoListMerging() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 3, 5));
        List<Integer> secondList = Arrays.asList(2, 6, 8);

        mergeListService.merge(firstList, secondList);

        List<Integer> expectedList = Arrays.asList(1, 2, 3, 5, 6, 8);
        assertEquals(expectedList, firstList);
    }
}
