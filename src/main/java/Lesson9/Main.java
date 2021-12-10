package Lesson9;

public class Main {
    public static void main(String[] args) throws Exception {
        double[][] arr = new double[2][2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;
        Matrix matrix1 = new Matrix(arr);
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setValue(0,0, 5);
        matrix2.setValue(0,1, 6);
        matrix2.setValue(1,0, 7);
        matrix2.setValue(1,1, 8);
        System.out.println("\nAddition");
        Matrix add = matrix1.addition(matrix2);
        add.print();
        System.out.println("\nSubtraction");
        Matrix deduct = matrix2.subtraction(matrix1);
        deduct.print();
        System.out.println("\nMultiplication");
        Matrix multiply = matrix1.multiply(matrix2);
        multiply.print();
    }
}