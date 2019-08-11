package by.zapolski.week02.task1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class BracketService {

    private Map<Character,Integer> openBracketMap = new HashMap<>();
    private Map<Character,Integer> closeBracketMap = new HashMap<>();

    public BracketService() {
        openBracketMap.put('(',0);
        openBracketMap.put('{',1);
        openBracketMap.put('[',2);

        closeBracketMap.put(')',0);
        closeBracketMap.put('}',1);
        closeBracketMap.put(']',2);
    }

    public Boolean checkStringWithBrackets(String source){

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        char[] chars = source.toCharArray();
        for (char ch: chars){



        }


        return deque.isEmpty();
    }
}
