package by.zapolski.week02;

import by.zapolski.week02.task2.AnagramService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnagramServiceTest {

    private AnagramService anagramService = new AnagramService();

    @Test
    public void getAnagramListWith3AnagramsTest(){
        String[] source = {"eat","tea","tan", "ate","nat","bat"};

        String expected = "[[ate, eat, tea], [bat], [nat, tan]]";
        String actual = anagramService.getAnagramList(source).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void getAnagramListWithoutAnagramsTest(){
        String[] source = {"123","456","789", "101","112","131"};

        String expected = "[[101], [123], [112], [131], [456], [789]]";
        String actual = anagramService.getAnagramList(source).toString();

        assertEquals(expected, actual);
    }

}
