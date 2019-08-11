package by.zapolski.week02.task2;

import java.util.*;

public class AnagramService {

    public ArrayList<TreeSet<String>> getAnagramList(String[] words){
        Map<String, TreeSet<String>> map = new HashMap<>();

        for(int i = 0; i <= words.length - 1; i++){
            String anagramCodeString = getAnagramCodeString(words[i]);

            TreeSet<String> valueTree = map.get(anagramCodeString);
            if(valueTree == null){
                valueTree = new TreeSet<>();
            }
            valueTree.add(words[i]);
            map.put(anagramCodeString, valueTree );
        }

        return new ArrayList<>( map.values());
    }

    private String getAnagramCodeString(String source){
        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
