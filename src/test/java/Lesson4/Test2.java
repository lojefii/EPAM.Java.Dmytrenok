package Lesson4;

import Lesson3.Task2;
import org.junit.jupiter.api.Test;
import Lesson3.SortOrder;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test2 {

    @Test
    void Transform() {
        int[] arr = {3, 5, 7, 10, 16, 22};
        int[] arr1 = {67, 54, 29, 13, 7};
        int[] arr2 = {9, 4, 13, 6, 12, 21};
        int[] arr3 = {105, 56, 90, 41, 86, 5};
        Task2.Transform(arr, SortOrder.ASC);
        Task2.Transform(arr1, SortOrder.DESC);
        Task2.Transform(arr2, SortOrder.ASC);
        Task2.Transform(arr3, SortOrder.DESC);
        assertArrayEquals(new int[]{3, 6, 9, 13, 20, 27}, arr);
        assertArrayEquals(new int[]{67, 55, 31, 16, 11}, arr1);
        assertArrayEquals(new int[]{9, 4, 13, 6, 12, 21}, arr2);
        assertArrayEquals(new int[]{105, 56, 90, 41, 86, 5}, arr3);
    }
}