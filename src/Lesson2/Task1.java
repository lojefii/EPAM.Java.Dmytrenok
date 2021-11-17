package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        System.out.print("Enter the array size: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr  = new int[size];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int halfLength = arr.length / 2;
        int temp;
        for (int i = 0; i < halfLength; i++) {
            if ((arr[i] % 2 == 0) && (arr[arr.length - i - 1] % 2 == 0)) {
                temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}