package nau.university.Lesson6;

import java.math.BigDecimal;

public class Manager extends Employee{

    private int quantity;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        this.quantity = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if (quantity > 100) {
            if (quantity > 150) {
                this.bonus = bonus.add(new BigDecimal(1000));
            } else {
                this.bonus = bonus.add(new BigDecimal(500));
            }
        } else {
            this.bonus = bonus;
        }
    }
}