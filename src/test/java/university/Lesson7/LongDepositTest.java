package university.Lesson7;

import nau.university.Lesson7.LongDeposit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongDepositTest {
    @Test
    void income_Test() {
        LongDeposit deposit = new LongDeposit(1000.0, 10);
        double income = deposit.income();
        assertEquals(749, income, 0.01);
    }
}
