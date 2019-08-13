package by.itacademy.laboratory.week.first.task3.model;

import lombok.AllArgsConstructor;

import java.util.Queue;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class CacheBox implements Callable<Integer> {

    private Queue<Buyer> buyers;

    @Override
    public Integer call() throws Exception {
        Integer result = 0;

        Buyer buyer;
        while ((buyer = buyers.poll()) != null) {
            result += buyer.getItemsAmount();
            Thread.sleep(buyer.getItemsAmount() * 1000);
        }

        return result;
    }
}
