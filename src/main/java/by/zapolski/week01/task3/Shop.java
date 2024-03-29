package by.zapolski.week01.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Shop {

    private Integer countCashboxes;
    private List<Customer> customerList;
    private List<Cashbox> threadList = new ArrayList<>();
    private SynchronousQueue<Customer> queue = new SynchronousQueue<>();

    public Shop(List<Customer> customerList, Integer countCashboxes) {
        this.customerList = customerList;
        this.countCashboxes = countCashboxes;
    }

    public long getTimeForProcessQueue() throws InterruptedException {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < countCashboxes; i++) {
            Cashbox cashbox = new Cashbox(queue,"cashbox_"+i);
            cashbox.start();
            threadList.add(cashbox);
        }

        for (Customer customer: customerList){
                queue.put(customer);
        }

        threadList.forEach(cb -> cb.disable());

        for (Cashbox cashbox: threadList){
            cashbox.join();
        }

        return Math.round( (System.currentTimeMillis()-startTime)/1000f );
    }

}
