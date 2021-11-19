package Lesson5;

public class ArrayRectangles {
    private Rectangle[] rectangle_array;

    public ArrayRectangles(int n) {
        rectangle_array = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle... rects) {
        rectangle_array = rects;
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle_array.length; i++) {
            if (rectangle_array[i] == null) {
                rectangle_array[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int numberMaxArea() {
        int max = 0;

        for (int i = 0; i < rectangle_array.length - 1; i++) {
            if (rectangle_array[i].area() > rectangle_array[max].area()) {
                max = i;
            }
        }
        return max;
    }

    public int numberMinPerimeter() {
        int min = 0;

        for (int i = 0; i < rectangle_array.length - 1; i++) {
            if (rectangle_array[i].perimeter() < rectangle_array[min].perimeter()) {
                min = i;
            }
        }
        return min;
    }

    public int numberSquare() {
        int count = 0;
        for (Rectangle rect : rectangle_array) {
            if (rect.isSquare())
                count++;
        }
        return count;
    }
}
