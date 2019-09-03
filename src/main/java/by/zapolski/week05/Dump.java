package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Dump {

    private List<Parts> parts;
    private Map<Long,Boolean> visitors;
    private static final Logger LOGGER = LoggerFactory.getLogger(Dump.class);

    public Dump() {
        this.parts = new ArrayList<>();
        this.visitors = new HashMap<>();
        initParts();
    }

    private void initParts() {
        for (int i = 0; i < Constants.INITIAL_DUMP_SIZE; i++) {
            parts.add(Parts.randomPart());
        }
        LOGGER.warn("Начальная свалка: {}, количество элементов: {}", parts, parts.size());
    }

    public synchronized void addRandomParts(int count) {

        if (visitors.get(Thread.currentThread().getId()) == null){
           visitors.put(Thread.currentThread().getId(),true) ;
        }

        while (visitors.get(Thread.currentThread().getId())){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < count; i++) {
            parts.add(Parts.randomPart());
            LOGGER.debug("Я свалка. В меня добавили: {}. Текущее количество элементов: {}", parts.get(parts.size()-1), parts.size());
        }

        visitors.put(Thread.currentThread().getId(),true);
    }

    public synchronized List<Parts> getAndRemoveRandomParts(int count) {

        if (visitors.get(Thread.currentThread().getId()) == null){
            visitors.put(Thread.currentThread().getId(),true);
        }

        while (visitors.get(Thread.currentThread().getId())){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Parts> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!parts.isEmpty()) {
                int index = new Random().nextInt(parts.size());
                result.add(parts.remove(index));
            }
        }
        visitors.put(Thread.currentThread().getId(),true);

        return result;
    }

    public synchronized void startNight() {
        for (Map.Entry<Long,Boolean> entry : visitors.entrySet()){
            entry.setValue(false);
        }
        notifyAll();
    }
}
