package nau.advanced.practice5.task2;

import java.util.concurrent.CountDownLatch;

public class Broker extends Thread {
    private int id;
    private int cash;
    private Request request;
    private Exchange exchange;

    public Broker(int id, int cash, Exchange exchange) {
        this.id = id;
        this.cash = cash;
        this.exchange = exchange;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getBrokerId() {
        return id;
    }

    public void addCash(int cash){
        this.cash += cash;
    }

    public void withdrawCash(int cash){
        this.cash -= cash;
    }

    @Override
    public void run() {
        CountDownLatch latch = exchange.getAuction();
        try {
            latch.await();
            exchange.addRequest(request);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Broker{Id = " + id + ", cash = " + cash + "}";
    }
}