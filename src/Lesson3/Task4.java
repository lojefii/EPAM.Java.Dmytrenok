package Lesson3;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Sum = " + SumGeometricElements(150.0, 0.5,30.0));
        System.out.println("Sum = " + SumGeometricElements(760.0, 0.3,12.0));
    }
    public static double SumGeometricElements(double a1, double t, double alim) {

        double result = 0;
        while (a1 > alim) {
            result += a1;
            a1 *= t;
        }
        return result;
    }
}