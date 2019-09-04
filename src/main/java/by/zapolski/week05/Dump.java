package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Dump {

    private List<Parts> parts;
    private Map<Long, Boolean> visitors;
    private static final Logger LOGGER = LoggerFactory.getLogger(Dump.class);
    private boolean available;

    public Dump() {
        this.parts = new ArrayList<>();
        this.visitors = new HashMap<>();
        this.available = true;
        initParts();
    }

    private void initParts() {
        for (int i = 0; i < UtilsAndConstants.INITIAL_DUMP_SIZE; i++) {
            parts.add(Parts.randomPart());
        }
        LOGGER.warn("Начальная свалка: {}, количество элементов: {}", parts, parts.size());
    }

    public synchronized void addRandomParts(int count) {

        myWait();
        LOGGER.debug("Фабрика решила добавить {} элементов.", count);
        for (int i = 0; i < count; i++) {
            parts.add(Parts.randomPart());
            LOGGER.debug("На свалку добавили: [{}]. Текущее количество элементов: {}", parts.get(parts.size() - 1), parts.size());
        }

        visitors.put(Thread.currentThread().getId(), true);
    }

    public synchronized List<Parts> getAndRemoveRandomParts(int count) {

        myWait();
        LOGGER.debug("{} решил стащить {} элементов. В наличии {}", Thread.currentThread().getName(), count, parts.size());
        List<Parts> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!parts.isEmpty()) {
                int index = new Random().nextInt(parts.size());
                result.add(parts.remove(index));
                LOGGER.debug("Я свалка. {} стащил: [{}]. Текущее количество элементов: {}", Thread.currentThread().getName(),
                        result.get(result.size() - 1), parts.size());
            }
        }

        visitors.put(Thread.currentThread().getId(), true);
        return result;
    }

    public synchronized void openAccess() {
        for (Map.Entry<Long, Boolean> entry : visitors.entrySet()) {
            entry.setValue(false);
        }
        notifyAll();
    }

    public synchronized Map<Long, Boolean> getVisitors() {
        return visitors;
    }

    private void myWait() {
        visitors.putIfAbsent(Thread.currentThread().getId(), true);
        while (visitors.get(Thread.currentThread().getId())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
