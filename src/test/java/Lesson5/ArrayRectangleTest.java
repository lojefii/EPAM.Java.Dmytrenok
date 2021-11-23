package Lesson5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayRectangleTest {
    @Test
    void addRectangle() {
        ArrayRectangles rectangles = new ArrayRectangles(2);
        assertTrue(rectangles.addRectangle(new Rectangle()));
        assertTrue(rectangles.addRectangle(new Rectangle()));
        assertFalse(rectangles.addRectangle(new Rectangle()));

        Rectangle[] rects = new Rectangle[]{new Rectangle()};
        rectangles = new ArrayRectangles(rects);
        assertFalse(rectangles.addRectangle(new Rectangle()));
    }

    @Test
    void numberMaxArea() {
        ArrayRectangles rectangles = new ArrayRectangles(4);
        rectangles.addRectangle(new Rectangle(9, 8));
        rectangles.addRectangle(new Rectangle(6));
        rectangles.addRectangle(new Rectangle());
        rectangles.addRectangle(new Rectangle(2, 12));
        assertEquals(0, rectangles.numberMaxArea());
    }

    @Test
    void numberMinPerimeter() {
        ArrayRectangles rectangles = new ArrayRectangles(4);
        rectangles.addRectangle(new Rectangle(3, 15));
        rectangles.addRectangle(new Rectangle(5));
        rectangles.addRectangle(new Rectangle());
        rectangles.addRectangle(new Rectangle(2, 4));
        assertEquals(3, rectangles.numberMinPerimeter());
    }

    @Test
    void numberSquare() {
        ArrayRectangles rectangles = new ArrayRectangles(4);
        rectangles.addRectangle(new Rectangle(3, 3));
        rectangles.addRectangle(new Rectangle(6, 5));
        rectangles.addRectangle(new Rectangle(10, 9));
        rectangles.addRectangle(new Rectangle(13, 13));
        assertEquals(2, rectangles.numberSquare());
    }
}