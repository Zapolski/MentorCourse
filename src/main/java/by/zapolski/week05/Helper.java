package by.zapolski.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper extends Thread {

    private Dump dump;
    private MadProfessor madProfessor;
    private List<Parts> pocket = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    public Helper(Dump dump, MadProfessor madProfessor) {
        this.dump = dump;
        this.madProfessor = madProfessor;
        setName("Helper_for_" + madProfessor.getName());
    }

    @Override
    public void run() {
        while (dump.isAvailable()) {
            stealFromDump();
            transferPartsToProfessor();
            madProfessor.makeRobot();
        }
    }

    private void stealFromDump() {
        int count = new Random().nextInt(4) + 1;
        pocket = dump.getAndRemoveRandomParts(count);
        LOGGER.debug("{} планировал украсть {} элементов. Украл: {}. Украденное: {}", getName(), count, pocket.size(), pocket);
    }

    private void transferPartsToProfessor() {
        LOGGER.debug("{} отдаю своему профессору {} элементов. Отдаваемое: {}", getName(), pocket.size(), pocket);
        while (!pocket.isEmpty()) {
            madProfessor.addParts(pocket.remove(0));
        }
        LOGGER.debug("У {} после отдачи: {}.", getName(), pocket);
    }


}
