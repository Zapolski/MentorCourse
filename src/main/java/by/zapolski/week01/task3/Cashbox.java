package by.zapolski.week01.task3;

import java.util.concurrent.SynchronousQueue;

public class Cashbox extends Thread{

    private final int TIME_FOR_ONE_GOOD = 1000;


    private SynchronousQueue queue;
    private boolean isActive;

    public Cashbox(SynchronousQueue queue,String name) {
        this.setName(name);
        this.queue = queue;
        isActive = true;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println("---> "+name+" starts working.");
        while (isActive){
            try {
                Customer customer = (Customer)queue.take();
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
