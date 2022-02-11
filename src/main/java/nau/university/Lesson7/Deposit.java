package nau.university.Lesson7;

public abstract class Deposit {

    private double amount;
    private int period;

    protected Deposit(double amount, int period) {
        setAmount(amount);
        setPeriod(period);
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    private void setPeriod(int period) {
        this.period = period;
    }

    abstract double income();
}