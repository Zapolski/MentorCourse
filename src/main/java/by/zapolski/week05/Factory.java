package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Factory extends Thread {

    private Dump dump;
    private int countNights;
    private static final Logger LOGGER = LoggerFactory.getLogger(Factory.class);

    public Factory(Dump dump, int countNights) {
        this.dump = dump;
        this.countNights = countNights;
    }

    @Override
    public void run() {

        LOGGER.warn("Начальная свалка: {}, количество элементов: {}", dump.getParts(), dump.getParts().size());
        for (int i = 0; i < countNights; i++) {
            int count = new Random().nextInt(4) + 1;
            for (int j = 0; j < count; j++) {
                dump.addRandomPart();
            }
            LOGGER.debug("Фабрика добавляет {} элемент(а). Кол-во эл-ов: {}. Текущая свалка: {}",
                    count, dump.getParts().size(), dump.getParts());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Dump dump = new Dump(3);
        Factory factory = new Factory(dump, 10);
        factory.start();
    }
}
