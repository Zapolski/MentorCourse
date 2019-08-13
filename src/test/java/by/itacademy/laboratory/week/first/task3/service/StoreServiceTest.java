package by.itacademy.laboratory.week.first.task3.service;

import by.itacademy.laboratory.week.first.task3.model.Buyer;
import by.itacademy.laboratory.week.first.task3.model.CacheBox;
import by.itacademy.laboratory.week.first.task3.model.Store;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

public class StoreServiceTest {

    private StoreService storeService = new StoreService();

    @Test
    public void shouldTake12Seconds() throws InterruptedException {
        Queue<Buyer> buyers = new LinkedBlockingQueue<>(Arrays.asList(
                new Buyer(5),
                new Buyer(3),
                new Buyer(4)
        ));

        Store store = new Store(Collections.singletonList(new CacheBox(buyers)));

        Integer actualTime = storeService.serveBuyers(store);
        Integer expectedTime = 12;
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void shouldTake10Seconds() throws InterruptedException {
        Queue<Buyer> buyers = new LinkedBlockingQueue<>(Arrays.asList(
                new Buyer(10),
                new Buyer(2),
                new Buyer(3),
                new Buyer(3)
        ));
        Store store = new Store(Arrays.asList(new CacheBox(buyers), new CacheBox(buyers)));

        Integer actualTime = storeService.serveBuyers(store);
        Integer expectedTime = 10;
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void shouldTake11Seconds() throws InterruptedException {
        Queue<Buyer> buyers = new LinkedBlockingQueue<>(Arrays.asList(
                new Buyer(1),
                new Buyer(3),
                new Buyer(10),
                new Buyer(4)
        ));

        Store store = new Store(Arrays.asList(new CacheBox(buyers), new CacheBox(buyers)));

        Integer actualTime = storeService.serveBuyers(store);
        Integer expectedTime = 11;
        assertEquals(expectedTime, actualTime);
    }
}
