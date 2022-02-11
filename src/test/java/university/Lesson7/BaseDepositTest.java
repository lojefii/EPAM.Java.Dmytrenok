package university.Lesson7;

import nau.university.Lesson7.BaseDeposit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseDepositTest {

    @Test
    void income_Test() {
        BaseDeposit deposit = new BaseDeposit(1000.0, 8);
        double income = deposit.income();
        assertEquals(477.46, income, 0.01);
    }
}