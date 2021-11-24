package Lesson6;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {

    void setBonus() {
    }

    @Test
    void setBonusLess100() {
        Manager manager = new Manager("Dmytrenok", new BigDecimal(15000), 60);
        manager.setBonus(new BigDecimal(800));
        assertEquals(new BigDecimal(800), manager.bonus);
    }

    @Test
    void setBonusBigger100() {
        Manager manager = new Manager("Heilenko", new BigDecimal(16000), 120);
        manager.setBonus(new BigDecimal(1600));
        assertEquals(new BigDecimal(2100), manager.bonus);
    }

    @Test
    void setBonusBigger150() {
        Manager manager = new Manager("Bespalko", new BigDecimal(17000), 180);
        manager.setBonus(new BigDecimal(3200));
        assertEquals(new BigDecimal(4200), manager.bonus);
    }

}