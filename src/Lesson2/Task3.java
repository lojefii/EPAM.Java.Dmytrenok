package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("Enter the matrix size: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] arr  = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = ((int)(Math.random() * 70 ) % 100);
            }
        }
        System.out.println(Arrays.deepToString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j > i) {
                    arr[i][j] = 1;
                } else if (j < i) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}