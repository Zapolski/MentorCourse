package by.itacademy.laboratory.week.second.task3.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajoritySearchService {

    public Integer findMajority(List<Integer> items) {
        Map<Integer, AtomicInteger> map = new HashMap<>();
        for (Integer item : items) {
            AtomicInteger counter = map.computeIfAbsent(item, k -> new AtomicInteger(0));
            counter.incrementAndGet();
        }

        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, AtomicInteger> it) -> it.getValue().get()).reversed())
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Integer findMajorityOptimal(List<Integer> items) {
        Integer result = items.get(0);
        int counter = 1;
        for (int i = 1; i < items.size(); i++) {
            Integer item = items.get(i);
            counter = item.equals(result) ? counter + 1 : counter - 1;
            if (counter < 0) {
                result = item;
                counter = 1;
            }
        }

        return result;
    }
}
