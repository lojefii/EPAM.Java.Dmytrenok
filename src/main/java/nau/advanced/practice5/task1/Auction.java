package nau.advanced.practice5.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Auction {
    private List<Lot> lots;
    private List<Participant> participants;
    private CountDownLatch beginLatch;
    private CountDownLatch endLatch;

    public Auction() {
        lots = new ArrayList<>();
        participants = new ArrayList<>();
        beginLatch = new CountDownLatch(1);
        endLatch = new CountDownLatch(1);
    }

    public CountDownLatch getStartLatch() {
        return beginLatch;
    }

    public CountDownLatch getFinishLatch() {
        return endLatch;
    }

    public boolean addParticipant(Participant participant) {
        return participants.add(participant);
    }

    public boolean addLot(Lot lot) {
        return lots.add(lot);
    }

    public Lot getLot() {
        return lots.get(0);
    }

    public boolean hasLots() {
        return !lots.isEmpty();
    }

    public void start() {
        beginLatch.countDown();
        beginLatch = new CountDownLatch(1);
    }

    public Participant finish() {
        Participant winner = participants.get(0);
        for (Participant participant : participants) {
            if ((participant.getCurrentLotPrice() > winner.getCurrentLotPrice()) && participant.hasAccess()) {
                winner = participant;
            }
        }
        removeTheLock();
        System.out.println("\nWinner{Id = " + winner.getParticipantId() + ", cash = "
                + winner.getCash() + ", price of the lot = " + winner.getCurrentLotPrice() + "}");
        if (!distractPrice(winner)) {
            System.out.println("The winner doesn`t have enough money");
            winner = null;
        }
        lots.remove(0);
        endLatch.countDown();
        beginLatch = new CountDownLatch(1);
        return winner;
    }

    private void removeTheLock() {
        for (Participant participant : participants) {
            if (!participant.hasAccess()) {
                participant.removeTheLock();
            }
        }
    }

    private boolean distractPrice(Participant participant) {
        if (!participant.payment()) {
            participant.setAccess(false);
            participant.setFineCounter(1);
            return false;
        }
        return true;
    }
}