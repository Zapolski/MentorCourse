package by.zapolski.week02.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DominantElementService {

    public Integer getDominantElement(List<Integer> sourceList){

        Integer currentDominantItem = sourceList.get(0);
        Integer currentDominantCount = 1;
        Map<Integer,Integer> counterMap = new HashMap<>(sourceList.size()/2+1);

        for (Integer item: sourceList){
            Integer currentCount = 1;
            if (counterMap.containsKey(item)){
                currentCount += counterMap.get(item);
                if (currentCount > currentDominantCount){
                    currentDominantCount = currentCount;
                    currentDominantItem = item;
                }
            }
            counterMap.put(item,currentCount);

            if (currentDominantCount>(sourceList.size()/2)){
                break;
            }
        }

        return currentDominantItem;
    }

    public Integer getDominantElementWithQuickSelect(List<Integer> sourceList){
        int[] array = new int[sourceList.size()];
        for (int i=0; i<sourceList.size();i++) {
            array[i]=sourceList.get(i);
        }
        return QuickSelect.selectIterative(array,array.length/2);
    }


}
