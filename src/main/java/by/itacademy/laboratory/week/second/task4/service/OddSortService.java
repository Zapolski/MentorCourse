package by.itacademy.laboratory.week.second.task4.service;

import java.util.PriorityQueue;
import java.util.Queue;

public class OddSortService {

    public void sort(int[] values) {
        Queue<Integer> oddValues = extractOddValues(values);
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 != 0) {
                values[i] = oddValues.poll();
            }
        }
    }

    private Queue<Integer> extractOddValues(int[] values) {
        Queue<Integer> oddValuesQueue = new PriorityQueue<>();
        for (int value : values) {
            if (value % 2 != 0) {
                oddValuesQueue.add(value);
            }
        }

        return oddValuesQueue;
    }
}
