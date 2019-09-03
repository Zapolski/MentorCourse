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
        while (true){
            int count = new Random().nextInt(4) + 1;
            dump.addRandomParts(count);
            LOGGER.debug("Фабрика решила добавить {} элементов.", count);
            try {
                Thread.sleep(Constants.DURATION_NIGHT_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
