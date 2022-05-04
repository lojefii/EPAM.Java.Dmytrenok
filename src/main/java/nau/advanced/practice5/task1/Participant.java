package nau.advanced.practice5.task1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Participant extends Thread{
    private int participantId;
    private int cash;
    private int currentLotPrice;
    private boolean access;
    private int fineCounter;
    private Auction auction;
    private CountDownLatch beginLatch;
    private CountDownLatch endLatch;

    public Participant(int participantId, int cash, Auction auction) {
        this.participantId = participantId;
        this.cash = cash;
        this.auction = auction;
        this.access = true;
        this.fineCounter = 0;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getCash() {
        return cash;
    }

    public int getCurrentLotPrice() {
        return currentLotPrice;
    }

    public boolean hasAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public void setFineCounter(int fineCounter) {
        this.fineCounter = fineCounter;
    }

    public void removeTheLock() {
        if (fineCounter != 0) {
            fineCounter--;
        }
        if (fineCounter == 0) {
            access = true;
        }
    }

    @Override
    public void run() {
        try {
            while (auction.hasLots()) {
                begin();
                if (access) {
                    currentLotPrice = getCurrentPrice();
                    raiseThePrice();
                    System.out.println(participantId + " -> " + currentLotPrice);
                } else {
                    currentLotPrice = 0;
                }
                end();
                System.out.println(this);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void raiseThePrice() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            this.currentLotPrice += random.nextInt(50);
            System.out.println("Update:" + participantId + " -> " + currentLotPrice);
        }
    }

    private int getCurrentPrice() {
        int price = auction.getLot().getStartPrice();
        Random random = new Random();
        this.currentLotPrice += random.nextInt(30);
        return price;
    }

    public void begin() throws InterruptedException {
        endLatch = auction.getFinishLatch();
        endLatch.await();
    }

    public void end() throws InterruptedException {
        beginLatch = auction.getStartLatch();
        beginLatch.await();
    }

    public boolean payment() {
        if (cash - currentLotPrice > 0) {
            cash -= currentLotPrice;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Participant{id = " + participantId + ", cash = " + cash
                + ", access = " + access + ", fineCounter = " + fineCounter + "}";
    }
}
