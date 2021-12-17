package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialDepositTest {
    @Test
    void income_Test() {
        SpecialDeposit deposit = new SpecialDeposit(1000.0, 8);
        double income = deposit.income();
        assertEquals(419.37, income, 0.01);
    }
}