package by.zapolski.week01.task4;

import java.util.ArrayList;
import java.util.List;

public class MergeService {

    public static List<Integer> mergeTwoLists(List<Integer> listA, List<Integer> listB){

        List<Integer> answer = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < listA.size() && j < listB.size()) {
            answer.add(listA.get(i) < listB.get(j) ? listA.get(i++) : listB.get(j++));
        }

        while (i < listA.size()) {
            answer.add(listA.get(i++));
        }

        while (j < listB.size()) {
            answer.add(listB.get(j++));
        }

        return answer;
    }

    public static List<Integer> mergeManyLists(List<Integer>... lists){
        List<Integer> answer = lists[0];
        for (int i = 1; i < lists.length; i++) {
            answer = mergeTwoLists(answer,lists[i]);
        }
        return answer;
    }
}
