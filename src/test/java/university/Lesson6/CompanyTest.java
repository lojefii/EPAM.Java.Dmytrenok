package university.Lesson6;

import nau.university.Lesson6.*;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {

    @Test
    void give_Everybody_Bonus_Test() {
        SalesPerson person1 = new SalesPerson("Dmytrenok", new BigDecimal(15000), 100);
        SalesPerson person2 = new SalesPerson("Voloshyn", new BigDecimal(17000), 100);
        Manager person3 = new Manager("Sydorova", new BigDecimal(25000), 100);
        Manager person4 = new Manager("Konoval", new BigDecimal(24000), 100);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        company.giveEverybodyBonus(new BigDecimal(3000));
        assertEquals(new BigDecimal(3000), person1.bonus);
        assertEquals(new BigDecimal(3000), person2.bonus);
        assertEquals(new BigDecimal(3000), person3.bonus);
        assertEquals(new BigDecimal(3000), person4.bonus);
    }

    @Test
    void total_To_Pay_Test() {
        SalesPerson person1 = new SalesPerson("Dmytrenok", new BigDecimal(15000), 220);
        SalesPerson person2 = new SalesPerson("Voloshyn", new BigDecimal(17000), 180);
        Manager person3 = new Manager("Sydorova", new BigDecimal(25000), 130);
        Manager person4 = new Manager("Konoval", new BigDecimal(24000), 160);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        assertEquals(person1.toPay().add(person2.toPay()).add(person3.toPay()).add(person4.toPay()),
                company.totalToPay());

        company.giveEverybodyBonus(new BigDecimal(5000));

        assertEquals(person1.toPay().add(person2.toPay()).add(person3.toPay()).add(person4.toPay()),
                company.totalToPay());
    }

    @Test
    void name_Max_Salary_Test() {
        SalesPerson person1 = new SalesPerson("Dmytrenok", new BigDecimal(15000), 220);
        SalesPerson person2 = new SalesPerson("Voloshyn", new BigDecimal(17000), 180);
        Manager person3 = new Manager("Sydorova", new BigDecimal(25000), 130);
        Manager person4 = new Manager("Konoval", new BigDecimal(24000), 160);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        assertEquals(person3.getName(), company.nameMaxSalary());
    }
}