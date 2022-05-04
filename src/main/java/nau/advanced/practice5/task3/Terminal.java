package nau.advanced.practice5.task3;

public class Terminal {
    private int humanCount;

    public Terminal(int humanCount) {
        this.humanCount = humanCount;
    }

    public int getHumanCount() {
        return humanCount;
    }

    public void increaseHumanCount(int count) {
        humanCount += count;
    }

    public void reduceHumanCount(int count) {
        humanCount -= count;
    }

    @Override
    public String toString() {
        return "Terminal{" + "human count = " + humanCount + "}";
    }
}
