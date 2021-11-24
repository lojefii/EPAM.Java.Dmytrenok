package Lesson6;

import java.math.BigDecimal;

public abstract class Employee {
    private String name;
    private BigDecimal salary;
    protected BigDecimal bonus;

    protected Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
        this.bonus = new BigDecimal(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) throws Exception {
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("Salary cannot be zero or less");
        }
        this.salary = salary;
    }

    public abstract void setBonus(BigDecimal bonus);

    public BigDecimal toPay() {
        return getSalary().add(bonus);
    }
}