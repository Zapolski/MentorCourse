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
        while (dump.isAvailable()) {
            int count = new Random().nextInt(4) + 1;
            dump.addRandomParts(count);
        }
    }
}
