package Lesson4;

import Lesson3.Task4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4 {

    @Test
    void SumGeometricElements() {
        assertEquals(262.5, Task4.SumGeometricElements(150.0, 0.5, 30.0));
        assertEquals(1076.92, Task4.SumGeometricElements(760.0, 0.3, 12.0));
    }
}