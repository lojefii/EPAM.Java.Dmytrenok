package Lesson3;

import java.util.Arrays;
import static Lesson3.Task1.IsSorted;

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = {6, 12, 23, 34, 35, 40};
        int[] arr2 = {77, 59, 40, 33, 27, 18, 5};
        int[] arr3 = {45, 78, 3, 65, 105, 12};

        System.out.println("Array -> " + Transform(arr1, SortOrder.ASC));
        System.out.println("Array -> " + Transform(arr1, SortOrder.DESC));
        System.out.println("Array -> " + Transform(arr2, SortOrder.ASC));
        System.out.println("Array -> " + Transform(arr2, SortOrder.DESC));
        System.out.println("Array -> " + Transform(arr3, SortOrder.ASC));
        System.out.println("Array -> " + Transform(arr3, SortOrder.DESC));
    }

    public static String Transform(int[] arr, SortOrder sortOrder) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        if (IsSorted(arr, sortOrder)) {
            for (int i = 0; i < arr.length; i++) {
                temp[i] += i;
            }
        }
        return Arrays.toString(temp);
    }
}
