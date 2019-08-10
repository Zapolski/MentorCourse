package by.zapolski.week01.task3;

import java.util.concurrent.SynchronousQueue;

public class Cashbox extends Thread{

    private final int TIME_FOR_ONE_GOOD = 1000;

    private SynchronousQueue<Customer> queue;
    private volatile boolean isActive;

    public Cashbox(SynchronousQueue<Customer> queue,String name) {
        this.setName(name);
        this.queue = queue;
        this.isActive = true;
    }

    @Override
    public void run() {
        String name = getName();

        System.out.println("---> "+name+" starts working.");
        while (isActive){
            try {
                Customer customer = queue.take();
                System.out.println(name+" took client with "+ customer.getQuantityGoods()+" goods.");
                for (int i = 0; i < customer.getQuantityGoods(); i++) {
                    Thread.sleep(TIME_FOR_ONE_GOOD);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---> "+name+" finished working");
    }

    public void disable(){
        isActive=false;
    }
}
