package Lesson3;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Result = " + ArithmeticProgression(2, 5, 4));
        System.out.println("Result = " + ArithmeticProgression(5, 3, 4));
    }
    public static int ArithmeticProgression(int a, int t, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
            a += t;
        }
        return result;
    }
}