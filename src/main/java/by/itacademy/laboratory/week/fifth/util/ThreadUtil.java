package by.itacademy.laboratory.week.fifth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ThreadUtil {

    public static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinThreads(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
