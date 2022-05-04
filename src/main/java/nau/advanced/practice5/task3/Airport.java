package nau.advanced.practice5.task3;

import java.util.Random;

public class Airport {
    private int id;
    private Terminal terminal;
    private Ladder[] ladders;

    public Airport(int id, int laddersCount, int humanCount) {
        this.id = id;
        terminal = new Terminal(humanCount);
        ladders = new Ladder[laddersCount];
        for (int i = 0; i < laddersCount; i++) {
            ladders[i] = new Ladder(i, this);
        }
    }

    public int getId() {
        return id;
    }

    public void boarding(Plane plane) {
        Ladder ladder = findLadder();
        Random random = new Random();
        if (ladder == null) {
            ladders[random.nextInt(ladders.length)].boarding(plane);
        } else {
            ladder.boarding(plane);
        }
    }

    public void disembarkation(Plane plane) {
        Ladder ladder = findLadder();
        Random random = new Random();
        if (ladder == null) {
            ladders[random.nextInt(ladders.length)].disembarkation(plane);
        } else {
            ladder.disembarkation(plane);
        }
    }

    private Ladder findLadder() {
        for (Ladder ladder : ladders) {
            if (ladder.getType() == LadderType.FREE) {
                return ladder;
            }
        }
        return null;
    }

    public void addPeople(int count){
        terminal.increaseHumanCount(count);
    }

    public void takeAwayPeople(int count){
        terminal.reduceHumanCount(count);
    }

    @Override
    public String toString() {
        return "Airport{" + "id = " + id + ", terminal human count = "
                + terminal.getHumanCount() + ", ladders count = " + ladders.length + "}";
    }
}
