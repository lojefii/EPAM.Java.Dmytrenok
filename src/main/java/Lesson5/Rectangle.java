package Lesson5;

public class Rectangle {
    private double A;
    private double B;

    public Rectangle(double A, double B) {
        this.A = A;
        this.B = B;
    }

    public Rectangle(double A) {
        this(A, 5);
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double area() {
        return A * B;
    }

    public double perimeter() {
        return (A + B) * 2;
    }

    public boolean isSquare() {
        return A == B;
    }

    //public void isSquare() {
    //    if(A == B)
    //        System.out.println("Figure is square");
    //     else
    //        System.out.println("Figure isn`t square");
    //}

    public void replaceSides() {
        double temp = A;
        A = B;
        B = temp;
    }
}