package nau.university.Lesson6;

import java.math.BigDecimal;

public class Company {

    private Employee[] staff;

    public Company(Employee... staff) {
        this.staff = staff;
    }

    public void giveEverybodyBonus(BigDecimal bonus) {
        for (var employee : staff) {
            employee.setBonus(bonus);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal total = new BigDecimal(0);
        for (var employee : staff) {
            total = total.add(employee.toPay());
        }
        return total;
    }

    public String nameMaxSalary() {
        int maxSalaryID = 0;
        for (int employee = 1; employee < staff.length; employee++) {
            if (staff[employee].toPay().compareTo(staff[maxSalaryID].toPay()) > 0) {
                maxSalaryID = employee;
            }
        }
        return staff[maxSalaryID].getName();
    }
}