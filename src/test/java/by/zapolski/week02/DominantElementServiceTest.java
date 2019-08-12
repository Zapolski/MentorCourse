package by.zapolski.week02;

import by.zapolski.week02.task3.DominantElementService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DominantElementServiceTest {

    DominantElementService dominantElementService = new DominantElementService();

    @Test
    public void getDominantElementTestForFiveElements(){
        List<Integer> source = Arrays.asList(10,9,9,9,10);
        Integer expected = 9;
        assertEquals(expected,dominantElementService.getDominantElement(source));
    }

    @Test
    public void getDominantElementTestForThreeElements(){
        List<Integer> source = Arrays.asList(3,2,3);
        Integer expected = 3;
        assertEquals(expected,dominantElementService.getDominantElement(source));
    }

    @Test
    public void getDominantElementTestSevenElements(){
        List<Integer> source = Arrays.asList(2,2,1,1,1,2,2);
        Integer expected = 2;
        assertEquals(expected,dominantElementService.getDominantElement(source));
    }

    @Test
    public void getDominantElementTestEightElements(){
        List<Integer> source = Arrays.asList(2,2,1,1,1,5,2,2);
        Integer expected = 2;
        assertEquals(expected,dominantElementService.getDominantElement(source));
    }

    @Test
    public void getDominantElementTestOneElements(){
        List<Integer> source = Arrays.asList(2);
        Integer expected = 2;
        assertEquals(expected,dominantElementService.getDominantElement(source));
    }
}
