package by.zapolski.week02;

import by.zapolski.week02.task4.MassiveSortService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MassiveSortServiceTest {

    MassiveSortService massiveSortService = new MassiveSortService();

    @Test
    public void getArrayWithSortedOddElements_WithOnlyOddElements(){
        Integer[] source = {11,9,7,5,3,1};
        Integer[] expected = {1,3,5,7,9,11};

        assertEquals(expected,massiveSortService.getArrayWithSortedOddElements(source));
    }

    @Test
    public void getArrayWithSortedOddElements_WithoutOddElements(){
        Integer[] source = {10,8,6,4,2,0};
        Integer[] expected = {10,8,6,4,2,0};

        assertEquals(expected,massiveSortService.getArrayWithSortedOddElements(source));
    }

    @Test
    public void getArrayWithSortedOddElements_WithOddElements(){
        Integer[] source = {10,9,8,7,6,5,4,3,2,1};
        Integer[] expected = {10,1,8,3,6,5,4,7,2,9};

        assertEquals(expected,massiveSortService.getArrayWithSortedOddElements(source));
    }
}
