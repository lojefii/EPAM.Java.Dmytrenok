package Lesson7;

public class LongDeposit extends Deposit {

    public LongDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double value = super.getAmount();
        for (int i = 0; i < getPeriod() - 6; i++) {
            value *= 1.15;
        }
        double scale = Math.pow(10, 2);
        double result = Math.ceil(value * scale) / scale;
        return result - super.getAmount();
    }
}