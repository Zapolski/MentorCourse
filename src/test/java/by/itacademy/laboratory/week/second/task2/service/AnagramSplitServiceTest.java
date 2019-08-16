package by.itacademy.laboratory.week.second.task2.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnagramSplitServiceTest {

    private AnagramSplitService anagramSplitService = new AnagramSplitService();

    @Test
    public void shouldSplitCorrectly() {
        String[] items = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> actualLists = anagramSplitService.groupAnagrams(items);

        List<List<String>> expectedLists = Arrays.asList(
                Arrays.asList("ate", "eat", "tea"),
                Arrays.asList("nat", "tan"),
                Collections.singletonList("bat")
        );

        assertEquals(expectedLists, actualLists);
    }
}