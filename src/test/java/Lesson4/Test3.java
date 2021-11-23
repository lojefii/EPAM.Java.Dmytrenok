package Lesson4;

import Lesson3.Task3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {

    @Test
    void ArithmeticProgression() {
        assertEquals(2856, Task3.ArithmeticProgression(2, 5, 4));
        assertEquals(6160, Task3.ArithmeticProgression(5, 3, 4));
    }
}