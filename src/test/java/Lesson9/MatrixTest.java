package Lesson9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    void set_Element_Test() {
        Matrix matrix = new Matrix(3, 3);

        matrix.setValue(0, 0, 3);

        assertEquals(3, matrix.getMatrix()[0][0]);
    }

    @Test
    void addition_Test() throws Exception {
        Matrix matrix1 = new Matrix(new double[][]{
                {1, 2},
                {3, 4},
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {5, 6},
                {7, 8},
        });

        Matrix matrixResult = matrix1.addition(matrix2);

        assertArrayEquals(new double[]{6, 8}, matrixResult.getMatrix()[0]);
        assertArrayEquals(new double[]{10, 12}, matrixResult.getMatrix()[1]);
    }

    @Test
    void subtraction_Test() throws Exception {
        Matrix matrix1 = new Matrix(new double[][]{
                {4, 6},
                {8, 10}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {1, 2},
                {3, 4}
        });

        Matrix matrixResult = matrix1.subtraction(matrix2);

        assertArrayEquals(new double[]{3, 4}, matrixResult.getMatrix()[0]);
        assertArrayEquals(new double[]{5, 6}, matrixResult.getMatrix()[1]);
    }

    @Test
    void multiplication_Test() throws Exception {
        Matrix matrix1 = new Matrix(new double[][]{
                {2, 3},
                {4, 5}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {4, 2},
                {5, 3}
        });

        Matrix matrixResult = matrix1.multiply(matrix2);

        assertArrayEquals(new double[]{23, 13}, matrixResult.getMatrix()[0]);
        assertArrayEquals(new double[]{41, 23}, matrixResult.getMatrix()[1]);
    }
    @Test
    void exception_Test() {
        Matrix matrix1 = new Matrix(new double[][]{
                {1, 2},
                {4, 5}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Exception exceptionAddition = assertThrows(Exception.class, () -> {
            Matrix matrixResult = matrix1.addition(matrix2);
        });
        Exception exceptionDeduction = assertThrows(Exception.class, () -> {
            Matrix matrixResult = matrix1.subtraction(matrix2);
        });
        Exception exceptionMultiplication = assertThrows(Exception.class, () -> {
            Matrix matrixResult = matrix1.multiply(matrix2);
        });

        assertEquals("Matrices have different sizes", exceptionAddition.getMessage());
        assertEquals("Matrices have different sizes", exceptionDeduction.getMessage());
        assertEquals("Matrices have different sizes", exceptionMultiplication.getMessage());
    }
    @Test
    void exception_Constructor_Test() {
        IllegalArgumentException exceptionRows = assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrix1 = new Matrix(-2,2);
        });
        IllegalArgumentException exceptionColumn = assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrix2 = new Matrix(3,-3);
        });

        assertEquals("The size of matrix is less than 1x1", exceptionRows.getMessage());
        assertEquals("The size of matrix is less than 1x1", exceptionColumn.getMessage());
    }
    @Test
    void exception_Set_Element_Test() {
        Matrix matrix = new Matrix(3,3);
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            matrix.setValue(6,2, 4);
        });

        assertEquals("The index is out of range", exception.getMessage());
    }
}