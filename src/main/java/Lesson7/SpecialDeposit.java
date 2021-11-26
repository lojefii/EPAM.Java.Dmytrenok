package Lesson7;

public class SpecialDeposit extends Deposit {

    public SpecialDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double value = super.getAmount();
        for (int i = 1; i <= getPeriod(); i++) {
            value *= 1.0 + (i / 100.0);
        }
        double scale = Math.pow(10, 2);
        double result = Math.ceil(value * scale) / scale;
        return result - super.getAmount();
    }
}