package by.itacademy.laboratory.week.second.task2.service;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramSplitService {

    public List<List<String>> groupAnagrams(String[] items) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(int i = 0; i < items.length; i++) {
            String currentItem = items[i];
            char[] currentCharArray = currentItem.toCharArray();
            Arrays.sort(currentCharArray);
            String mapKey = new String(currentCharArray);
            List<String> mapValue = map.computeIfAbsent(mapKey, k -> new ArrayList<>());
            mapValue.add(currentItem);
        }

        return map.values().stream()
                .peek(list -> list.sort(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
