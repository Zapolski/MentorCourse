package by.zapolski.week05;

public class UtilsAndConstants {
    private UtilsAndConstants(){
        throw new IllegalAccessError();
    }

    public static final int COUNT_NIGHTS = 100;
    public static final int INITIAL_DUMP_SIZE = 20;
    public static final int DURATION_NIGHT_MS = 100;

    public static void mySleep(long delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
