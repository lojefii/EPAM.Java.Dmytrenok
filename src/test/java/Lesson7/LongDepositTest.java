package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongDepositTest {
    @Test
    void income() {
        LongDeposit deposit = new LongDeposit(1000.0, 10);
        double income = deposit.income();
        assertEquals(749, income, 0.01);
    }
}
