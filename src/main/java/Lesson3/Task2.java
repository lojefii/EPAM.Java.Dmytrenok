package Lesson3;

import java.util.Arrays;
import static Lesson3.Task1.IsSorted;

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = {6, 12, 23, 34, 35, 40};
        int[] arr2 = {77, 59, 40, 33, 27, 18, 5};
        int[] arr3 = {45, 78, 3, 65, 105, 12};

        Transform(arr1, SortOrder.ASC);
        System.out.println("Array -> " + Arrays.toString(arr1));
        Transform(arr1, SortOrder.DESC);
        System.out.println("Array -> " + Arrays.toString(arr1));
        Transform(arr2, SortOrder.ASC);
        System.out.println("Array -> " + Arrays.toString(arr2));
        Transform(arr2, SortOrder.DESC);
        System.out.println("Array -> " + Arrays.toString(arr1));
        Transform(arr3, SortOrder.ASC);
        System.out.println("Array -> " + Arrays.toString(arr3));
        Transform(arr3, SortOrder.DESC);
        System.out.println("Array -> " + Arrays.toString(arr3));
    }

    public static void Transform(int[] arr, SortOrder sortOrder) {
        if (IsSorted(arr, sortOrder)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += i;
            }
        }
    }
}