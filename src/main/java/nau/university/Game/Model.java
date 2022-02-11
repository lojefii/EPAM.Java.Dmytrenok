package nau.university.Game;

import java.util.ArrayList;

public class Model {
    private int min;
    private int max;
    int random = rand(0, 100);

    private ArrayList<Integer> stat = new ArrayList<>();

    public void setRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRandom(){
        return random;
    }

    public void addStat(int st) {
        stat.add(st);
    }

    private int rand(int min, int max) {
        int rand = min + (int) (Math.random() * max);
        return rand;
    }

    public ArrayList<Integer> getStat(){
        return stat;
    }
}