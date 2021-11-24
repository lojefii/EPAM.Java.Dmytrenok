package Lesson6;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesPersonTest {

    @Test
    void setBonus() {
    }

    @Test
    void setBonusLess100() {
        SalesPerson person = new SalesPerson("Dmytrenok", new BigDecimal(15000), 60);
        person.setBonus(new BigDecimal(800));
        assertEquals(new BigDecimal(800), person.bonus);
    }

    @Test
    void setBonusBigger100() {
        SalesPerson person = new SalesPerson("Heilenko", new BigDecimal(16000), 120);
        person.setBonus(new BigDecimal(1600));
        assertEquals(new BigDecimal(3200), person.bonus);
    }

    @Test
    void setBonusBigger200() {
        SalesPerson person = new SalesPerson("Bespalko", new BigDecimal(17000), 240);
        person.setBonus(new BigDecimal(3200));
        assertEquals(new BigDecimal(9600), person.bonus);
    }
}