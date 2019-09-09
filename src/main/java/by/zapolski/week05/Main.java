package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.zapolski.week05.UtilsAndConstants.*;

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
        mySleep(500);

        for (int i = 0; i < COUNT_NIGHTS; i++) {
            LOGGER.warn("--------------> Наступила ночь! {} <-------------------",i+1);
            dump.openAccess();
            mySleep(DURATION_NIGHT_MS);
        }
        dump.setAvailable(false);
    }
}
