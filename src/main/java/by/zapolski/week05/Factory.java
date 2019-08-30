package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Factory extends Thread {

    private Dump dump;
    private static final Logger LOGGER = LoggerFactory.getLogger(Factory.class);

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {

        LOGGER.warn("Начальная свалка: {}, количество элементов: {}", dump.getParts(), dump.getParts().size());
        for (int i = 0; i < Constants.COUNT_NIGHTS; i++) {
            int count = new Random().nextInt(4) + 1;
            for (int j = 0; j < count; j++) {
                dump.addRandomPart();
            }
            LOGGER.debug("-----------> Фабрика добавляет {} элемент(а). Кол-во эл-ов: {}. Текущая свалка: {}",
                    count, dump.getParts().size(), dump.getParts());
            try {
                Thread.sleep(Constants.DURATION_NIGHT_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
