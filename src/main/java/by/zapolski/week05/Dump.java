package by.zapolski.week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dump {

    private List<Parts> parts;

    public Dump() {
        this.parts = new ArrayList<>();
        initParts();
    }

    private void initParts() {
        for (int i = 0; i < Constants.INITIAL_DUMP_SIZE; i++) {
            parts.add(Parts.randomPart());
        }
    }

    public synchronized int getSize() {
        return parts.size();
    }

    // for debug
    public synchronized List<Parts> getParts() {
        return parts;
    }

    public synchronized void addRandomPart() {
        parts.add(Parts.randomPart());
    }

    public synchronized Parts getAndRemoveRandomPart() {
        if (!parts.isEmpty()) {
            int index = new Random().nextInt(parts.size());
            return parts.remove(index);
        }
        return null;
    }
}
