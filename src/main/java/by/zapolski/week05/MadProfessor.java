package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MadProfessor {

    private Map<Parts, Integer> stock;
    private int countReadyRobot = 0;
    private String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(MadProfessor.class);

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

    private boolean tryMakeRobot() {
        long countAvailableTypeParts = stock.entrySet().stream().filter(entry -> entry.getValue() > 0).count();
        if (countAvailableTypeParts == Parts.SIZE) {
            stock.entrySet().forEach(entry -> entry.setValue(entry.getValue() - 1));
            countReadyRobot++;
            return true;
        }
        return false;
    }

    public void addParts(Parts part) {
        stock.put(part, stock.get(part) + 1);
    }

    public int getCountReadyRobot() {
        return countReadyRobot;
    }

    public String getName() {
        return name;
    }

    public void makeRobot() {
        while (tryMakeRobot()) {
            LOGGER.debug("Профессор {} удачно создал робота.", name);
        }
        LOGGER.debug("У профессора {} {} роботов. Склад: {}", name, countReadyRobot, stock);
    }
}
