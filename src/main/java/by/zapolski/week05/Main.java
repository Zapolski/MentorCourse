package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Dump dump = new Dump();
        Factory factory = new Factory(dump);

        MadProfessor madProfessor1 = new MadProfessor("Prof_1");
        MadProfessor madProfessor2 = new MadProfessor("Prof_2");

        Helper helper1 = new Helper(dump,madProfessor1);
        Helper helper2 = new Helper(dump,madProfessor2);

        helper1.start();
        helper2.start();
        factory.start();

        for (int i = 0; i < Constants.COUNT_NIGHTS; i++) {
            LOGGER.warn("--------------> Наступила ночь! <-------------------");
            dump.startNight();
            try {
                Thread.sleep(Constants.DURATION_NIGHT_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
