package Lesson5;

public class ArrayRectangles {
    private Rectangle[] rectangleArray;

    public ArrayRectangles(int n) {
        rectangleArray = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle... rects) {
        rectangleArray = rects;
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int numberMaxArea() {
        int max = 0;

        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i].area() > rectangleArray[max].area()) {
                max = i;
            }
        }
        return max;
    }

    public int numberMinPerimeter() {
        int min = 0;

        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i].perimeter() < rectangleArray[min].perimeter()) {
                min = i;
            }
        }
        return min;
    }

    public int numberSquare() {
        int count = 0;
        for (Rectangle rect : rectangleArray) {
            if (rect.isSquare())
                count++;
        }
        return count;
    }
}
