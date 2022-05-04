package nau.advanced.practice5.task3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ladder {
    private int id;
    private LadderType type = LadderType.FREE;
    private final Lock lock = new ReentrantLock();
    private Airport airport;

    public Ladder(int id, Airport airport) {
        this.id = id;
        this.airport = airport;
    }

    public LadderType getType() {
        return type;
    }

    public void setType(LadderType type) {
        if (type == LadderType.FREE) {
            type = LadderType.FREE;
        } else {
            type = LadderType.BUSY;
        }
    }

    public void boarding(Plane plane){
        try{
            lock.lock();
            setType(LadderType.BUSY);
            System.out.println("Airport:" + airport.getId() + " Ladder:" + id + " -> Plane boarding: " + plane);
            airport.takeAwayPeople(plane.getCapacity());
            TimeUnit.MILLISECONDS.sleep(plane.getTime());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            setType(LadderType.FREE);
            System.out.println("Airport:" + airport.getId() + ", ladder:" + id + " -> Ladder free");
            lock.unlock();
        }
    }

    public void disembarkation(Plane plane){
        try{
            lock.lock();
            System.out.println("Airport:" + airport.getId() + ", ladder:" + id + " -> Plane disembarkation: " + plane);
            setType(LadderType.BUSY);
            airport.addPeople(plane.getCapacity());
            TimeUnit.MILLISECONDS.sleep(plane.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setType(LadderType.FREE);
            System.out.println("Airport:" + airport.getId() + " Ladder:" + id + " -> Ladder free");
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Ladder{type = " + type + ", airport id = " + airport.getId() + "}";
    }
}