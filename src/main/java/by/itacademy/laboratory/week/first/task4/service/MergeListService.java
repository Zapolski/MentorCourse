package by.itacademy.laboratory.week.first.task4.service;

import java.util.ArrayList;
import java.util.List;

public class MergeListService {

    public void merge(List<Integer> firstList, List<Integer> secondList) {
        int commonCapacity = firstList.size() + secondList.size();
        List<Integer> result = new ArrayList<>(commonCapacity);

        for(int i = 0, firstIndex = 0, secondIndex = 0; i < commonCapacity; i++) {
            if (firstList.size() > firstIndex && secondList.size() > secondIndex) {
                if (firstList.get(firstIndex) < secondList.get(secondIndex)) {
                    result.add(firstList.get(firstIndex++));
                } else {
                    result.add(secondList.get(secondIndex++));
                }
            } else if (firstList.size() > firstIndex) {
                result.add(firstList.get(firstIndex++));
            } else {
                result.add(secondList.get(secondIndex++));
            }
        }
        firstList.clear();
        firstList.addAll(result);
    }
}
