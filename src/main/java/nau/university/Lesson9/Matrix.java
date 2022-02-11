package nau.university.Lesson9;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;
    final int rows;
    final int columns;

    public Matrix(int rows, int columns) {
        if (rows < 1 || columns < 1)
            throw new IllegalArgumentException("The size of matrix is less than 1x1");
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    public Matrix(double[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            throw new ArrayIndexOutOfBoundsException("The index of array is less than 1");
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = Arrays.copyOf(matrix, matrix.length);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void getValue(int row, int column) {
        try {
            if (row > matrix.length || row < 0
                    || column > matrix[0].length || column < 0) {
                throw new ArrayIndexOutOfBoundsException("These values are not in range");
            }
            System.out.println(matrix[row][column]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setValue(int row, int column, double value) {
        if (row < 0 || column < 0 || row > matrix.length || column > matrix[0].length)
            throw new ArrayIndexOutOfBoundsException("The index is out of range");
        matrix[row][column] = value;
    }

    public Matrix addition(Matrix matrix) throws Exception {
        Matrix result = new Matrix(rows, columns);
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new Exception("Matrices have different sizes");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = this.matrix[i][j] + matrix.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix subtraction(Matrix matrix) throws Exception {
        Matrix result = new Matrix(rows, columns);
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new Exception("Matrices have different sizes");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = this.matrix[i][j] - matrix.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix matrix) throws Exception {
        Matrix result = new Matrix(rows, columns);
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new Exception("Matrices have different sizes");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < columns; k++)
                    result.matrix[i][j] += this.matrix[i][k] * matrix.matrix[k][j];
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            System.out.print("{ ");
            for (int j = 0; j < columns - 1; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.print(matrix[i][columns - 1] );
            System.out.println(" }");
        }
    }
}