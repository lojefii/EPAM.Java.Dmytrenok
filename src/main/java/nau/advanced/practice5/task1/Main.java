package nau.advanced.practice5.task1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Auction auction = new Auction();
        auction.addLot(new Lot("Picture", 300));
        auction.addLot(new Lot("Vase", 200));
        auction.addLot(new Lot("Diamond", 600));
        auction.addLot(new Lot("Sculpture", 400));

        Random random = new Random();
        Participant participant1 = new Participant(0, random.nextInt(1500), auction);
        Participant participant2 = new Participant(1, random.nextInt(1500), auction);
        Participant participant3 = new Participant(2, random.nextInt(1500), auction);
        Participant participant4 = new Participant(3, random.nextInt(1500), auction);
        auction.addParticipant(participant1);
        auction.addParticipant(participant2);
        auction.addParticipant(participant3);
        auction.addParticipant(participant4);
        participant1.start();
        participant2.start();
        participant3.start();
        participant4.start();

        while (auction.hasLots()) {
            System.out.println("\nStart auction\n" + auction.getLot() + "\n");
            auction.start();
            TimeUnit.SECONDS.sleep(3);
            auction.finish();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
