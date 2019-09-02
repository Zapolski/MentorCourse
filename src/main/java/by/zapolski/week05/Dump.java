package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dump {

    private List<Parts> parts;
    private static final Logger LOGGER = LoggerFactory.getLogger(Dump.class);

    public Dump() {
        this.parts = new ArrayList<>();
        initParts();
    }

    private void initParts() {
        for (int i = 0; i < Constants.INITIAL_DUMP_SIZE; i++) {
            parts.add(Parts.randomPart());
        }
        LOGGER.warn("Начальная свалка: {}, количество элементов: {}", parts, parts.size());
    }

    public synchronized void addRandomParts(int count) {
        for (int i = 0; i < count; i++) {
            parts.add(Parts.randomPart());
            LOGGER.warn("Я свалка. В меня добавили: {}. Текущее количество элементов: {}", parts.get(parts.size()-1), parts.size());
        }
        notifyAll();
    }

    public synchronized List<Parts> getAndRemoveRandomParts(int count) {

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Parts> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!parts.isEmpty()) {
                int index = new Random().nextInt(parts.size());
                result.add(parts.remove(index));
            }
        }
        return result;
    }
}
