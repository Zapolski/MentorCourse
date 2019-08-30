package by.zapolski.week05;

import java.util.HashMap;
import java.util.Map;

public class MadProfessor {

    private Map<Parts, Integer> stock;
    private int countReadyRobot = 0;

    public MadProfessor() {
        this.stock = new HashMap<>();
        initStock();
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

    public void addParts(Parts part){
        stock.put(part,stock.get(part)+1);
    }

    // for debug
    public Map<Parts, Integer> getStock() {
        return stock;
    }

    public static void main(String[] args) {

        MadProfessor madProfessor = new MadProfessor();
        System.out.println("Создали профессора: "+madProfessor.getStock());

        for (Parts part : Parts.VALUES) {
            madProfessor.addParts(part);
        }

        System.out.println("Напихали профессора: "+madProfessor.getStock());
        System.out.println("Пробую делать робота: "+madProfessor.tryMakeRobot());
        System.out.println("После пробы: "+madProfessor.getStock());
    }
}
