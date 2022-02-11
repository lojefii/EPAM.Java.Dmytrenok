package nau.university.Lesson7;

public class BaseDeposit extends Deposit {

    public BaseDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double value = super.getAmount();
        for (int i = 0; i < super.getPeriod(); i++) {
            value *= 1.05;
        }
        double scale = Math.pow(10, 2);
        double result = Math.ceil(value * scale) / scale;
        return result - super.getAmount();
    }
}