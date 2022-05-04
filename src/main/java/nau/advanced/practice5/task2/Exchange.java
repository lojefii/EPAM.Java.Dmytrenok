package nau.advanced.practice5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exchange {
    private List<Request> requestList = new ArrayList<>();
    private CountDownLatch auction = new CountDownLatch(1);
    private Lock lock = new ReentrantLock();

    public CountDownLatch getAuction() {
        return auction;
    }

    public void startAuction() {
        System.out.println("Auction has started");
        auction.countDown();
    }

    public void closeAuction() {
        System.out.println("Auction has closed");
        auction = new CountDownLatch(1);
        for (var request : requestList) {
            System.out.println(request);
        }
    }

    public void addRequest(Request request) {
        try {
            lock.lock();
            while (auction.getCount() != 0) {
                auction.await();
            }
            System.out.println("\nThe request is being executed: \n" + request);
            if (!conductTransaction(request)) {
                System.out.println("Request sent");
                requestList.add(request);
                status();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private boolean conductTransaction(Request request) {
        if (request.getType() == RequestType.BUY) {
            return purchaseTransaction(request);
        } else if (request.getType() == RequestType.SELL) {
            return salesTransaction(request);
        }
        return false;
    }

    private boolean purchaseTransaction(Request request) {
        Request purchaseRequest = findRequest(request);
        if (purchaseRequest == null) {
            return false;
        }
        System.out.println("Transaction successful");
        requestList.remove(purchaseRequest);
        int price = (int) ((purchaseRequest.getExchangeRate() * purchaseRequest.getAmount()) *
                (1.0 - getExchangeRate(purchaseRequest.getCurrency())));

        System.out.println("Broker bought\n" + request.getBroker() + "+" + price);
        request.getBroker().withdrawCash(price);

        System.out.println("Broker sold\n" + purchaseRequest.getBroker() + "-" + price);
        purchaseRequest.getBroker().addCash(price);
        return true;
    }

    private boolean salesTransaction(Request request) {
        Request salesRequest = findRequest(request);
        if (salesRequest == null) {
            return false;
        }
        System.out.println("Transaction successful");
        requestList.remove(salesRequest);
        int price = (int) ((salesRequest.getExchangeRate() * salesRequest.getAmount()) *
                (1.0 + getExchangeRate(salesRequest.getCurrency())));

        System.out.println("sell broker\n" + request.getBroker() + "+" + price);
        request.getBroker().addCash(price);

        System.out.println("buy broker\n" + salesRequest.getBroker() + "-" + price);
        salesRequest.getBroker().withdrawCash(price);
        return true;
    }

    private double getExchangeRate(String currency) {
        int count = 0;
        for (Request request : requestList) {
            if (request.getCurrency().equals(currency)) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return 1.0 / count;
    }

    private Request findRequest(Request request) {
        for (Request req : requestList) {
            if (req.getType() == request.getType() && Objects.equals(req.getCurrency(), request.getCurrency())
                    && req.getAmount() == request.getAmount() && req.getExchangeRate() == request.getExchangeRate()) {
                return req;
            }
        }
        return null;
    }

    private void status() {
        int buyCount = 0;
        int sellCount = 0;
        for (Request request : requestList) {
            if (request.getType() == RequestType.BUY) {
                buyCount++;
            } else if (request.getType() == RequestType.SELL){
                sellCount++;
            }
        }
        if (buyCount >= 4 || sellCount >= 4) {
            closeAuction();
        }
    }
}
