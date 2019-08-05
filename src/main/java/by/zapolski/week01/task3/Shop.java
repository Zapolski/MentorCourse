package by.zapolski.week01.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Shop {

    //final static SynchronousQueue queue1 = new SynchronousQueue();
    //final static List<Customer> customerList1 = new ArrayList<>();

    private Integer countCashboxes;
    private List<Customer> customerList;
    private List<Cashbox> threadList;
    private SynchronousQueue queue;

    public Shop(List<Customer> customerList, Integer countCashboxes) {
        this.customerList = customerList;
        this.countCashboxes = countCashboxes;

        this.queue = new SynchronousQueue();
        this.threadList = new ArrayList<>();
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

        for (Cashbox cashbox: threadList){
            cashbox.disable();
        }
        for (Cashbox cashbox: threadList){
            cashbox.join();
        }

        return Math.round( (System.currentTimeMillis()-startTime)/1000 );
    }

}
