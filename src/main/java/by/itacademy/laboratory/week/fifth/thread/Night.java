package by.itacademy.laboratory.week.fifth.thread;

import by.itacademy.laboratory.week.fifth.util.NightConst;

public class Night extends Thread {

    private final Object LOCK = new Object();

    @Override
    public void run() {
        for (int i = 0; i < NightConst.AMOUNT_OF_NIGHT; i++) {
            synchronized (LOCK) {
                try {
                    System.out.printf("----------------\nNight %s started\n", (i + 1));
                    LOCK.notifyAll();
                    LOCK.wait(NightConst.NIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }

    public Object getLock() {
        return LOCK;
    }
}
