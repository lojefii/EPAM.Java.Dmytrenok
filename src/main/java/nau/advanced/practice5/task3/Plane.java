package nau.advanced.practice5.task3;

import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private static int countId = 0;
    private int id;
    private int capacity;
    private RangeType range;
    private Airport lendingAirport;
    private Airport destinationAirport;

    public Plane(int capacity, RangeType range) {
        id = countId++;
        this.capacity = capacity;
        this.range = range;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setLendingAirport(Airport airport) {
        lendingAirport = airport;
    }

    public void setDestinationAirport(Airport airport) {
        destinationAirport = airport;
    }

    @Override
    public void run() {
        try {
            lendingAirport.boarding(this);
            TimeUnit.MILLISECONDS.sleep(getTime());
            destinationAirport.disembarkation(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int getTime(){
        int time = 0;
        switch (range) {
            case CLOSE:
                time = 3000;
                break;
            case AVERAGE:
                time = 2000;
                break;
            case FAR:
                time = 1000;
                break;
        }
        return time;
    }

    @Override
    public String toString() {
        return "Plane{id = " + id + ", capacity = " + capacity + ", range = " + range + ", airport id = "
                + lendingAirport.getId() + ", destination airport id = " + destinationAirport.getId() + '}';
    }
}