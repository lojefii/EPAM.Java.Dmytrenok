package nau.university.Lesson7;

public class Client {

    private Deposit[] deposits;
    private int index;

    public Client() {
        deposits = new Deposit[10];
        index = 0;
    }

    public boolean addDeposit(Deposit deposit) {
        if (index >= 10) {
            return false;
        }
        deposits[index++] = deposit;
        return true;
    }

    public double totalIncome() {
        double total = 0.0;
        for (int i = 0; i < index; i++) {
            total += deposits[i].income();
        }
        return total;
    }

    public double maxIncome() {
        double max = 0.0;
        for (int i = 0; i < index; i++) {
            if (deposits[i].income() > max) {
                max = deposits[i].income();
            }
        }
        return max;
    }

    public double getIncomeByNumber(int number) {
        number--;
        if (number <= 0 || number > index) {
            return 0;
        }
        return deposits[number].income();
    }
}