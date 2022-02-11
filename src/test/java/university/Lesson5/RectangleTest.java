package university.Lesson5;

import nau.university.Lesson5.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void getA_Test() {
        assertEquals(5, new Rectangle(5, 9).getA());
        assertEquals(12, new Rectangle(12).getA());
        assertEquals(4, new Rectangle().getA());
    }

    @Test
    void getB_Test() {
        assertEquals(4, new Rectangle(8, 4).getB());
        assertEquals(5, new Rectangle(8).getB());
        assertEquals(3, new Rectangle().getB());
    }

    @Test
    void area_Test() {
        assertEquals(15, new Rectangle(5, 3).area());
        assertEquals(40, new Rectangle(8).area());
        assertEquals(12, new Rectangle().area());
    }

    @Test
    void perimeter_Test() {
        assertEquals(24, new Rectangle(8, 4).perimeter());
        assertEquals(18, new Rectangle(4).perimeter());
        assertEquals(14, new Rectangle().perimeter());
    }

    @Test
    void is_Square_Test() {
        assertTrue(new Rectangle(12, 12).isSquare());
        assertTrue(new Rectangle(5).isSquare());

        assertFalse(new Rectangle(8, 3).isSquare());
        assertFalse(new Rectangle().isSquare());
    }

    @Test
    void replace_Sides_Test() {
        Rectangle rectangle = new Rectangle(15, 9);

        rectangle.replaceSides();

        assertEquals(9, rectangle.getA());
        assertEquals(15, rectangle.getB());
    }

    @Test
    void test_Exception_Test() {
        ExceptionInInitializerError exception = Assertions.assertThrows(ExceptionInInitializerError.class, () -> {
            Rectangle rect = new Rectangle(-4, 0);});

        Assertions.assertEquals("The sides cannot be 0 or less", exception.getMessage());
    }
}