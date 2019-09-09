package by.zapolski.week05;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Parts {

    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    public static final List<Parts> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Parts randomPart()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
