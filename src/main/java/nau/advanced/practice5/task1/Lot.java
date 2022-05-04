package nau.advanced.practice5.task1;

public class Lot {
    private int id;
    private String name;
    private int startPrice;
    private static int countId = 0;

    public Lot(String name, int startPrice) {
        this.id = countId++;
        this.name = name;
        this.startPrice = startPrice;
    }

    public String getName() {
        return name;
    }

    public int getStartPrice() {
        return startPrice;
    }

    @Override
    public String toString() {
        return "Lot{id = " + id + ", name - " + name + ", startPrice = " + startPrice + "}";
    }
}
