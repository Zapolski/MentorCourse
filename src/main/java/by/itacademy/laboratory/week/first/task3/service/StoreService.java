package by.itacademy.laboratory.week.first.task3.service;

import by.itacademy.laboratory.week.first.task3.model.Store;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.HOURS;

public class StoreService {

    public Integer serveBuyers(Store store) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(store.getCacheBoxes().size());
        List<Future<Integer>> futures = executorService.invokeAll(store.getCacheBoxes(), 1L, HOURS);
        executorService.shutdown();

        return futures.stream()
                .map(this::getValue)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
    }

    private <T> T getValue(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
