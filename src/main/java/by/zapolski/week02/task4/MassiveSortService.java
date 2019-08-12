package by.zapolski.week02.task4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MassiveSortService {

    public Integer[] getArrayWithSortedOddElements(Integer[] source){

        List<Integer> list = Arrays.stream(source)
                                   .filter(item -> item%2!=0)
                                   .sorted()
                                   .collect(Collectors.toList());

        int index = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i]%2!=0){
                source[i]=list.get(index++);
            }
        }
        return source;
    }

}
