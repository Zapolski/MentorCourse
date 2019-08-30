package by.zapolski.week05;

import java.util.HashMap;
import java.util.Map;

public class MadProfessor {

    private Map<Parts, Integer> stock;
    private int countReadyRobot = 0;
    private String name;

    public MadProfessor(String name) {
        this.stock = new HashMap<>();
        initStock();
        this.name = name;
    }

    private void initStock() {
        for (Parts part : Parts.values()) {
            stock.put(part, 0);
        }
    }

    public boolean tryMakeRobot() {
        long countAvailableTypeParts = stock.entrySet().stream().filter(entry -> entry.getValue() > 0).count();
        if (countAvailableTypeParts == Parts.SIZE) {
            stock.entrySet().forEach(entry -> entry.setValue(entry.getValue() - 1));
            countReadyRobot++;
            return true;
        }
        return false;
    }

    public void addParts(Parts part){
        stock.put(part,stock.get(part)+1);
    }

    public int getCountReadyRobot() {
        return countReadyRobot;
    }

    public String getName() {
        return name;
    }

    // for debug
    public Map<Parts, Integer> getStock() {
        return stock;
    }
}
