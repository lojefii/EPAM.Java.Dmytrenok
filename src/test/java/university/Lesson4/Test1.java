package university.Lesson4;

import nau.university.Lesson3.Task1;
import org.junit.jupiter.api.Test;
import nau.university.Lesson3.SortOrder;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1 {

    @Test
    void isSorted() {
        int[] arr = {3, 5, 7, 10, 16, 22};
        int[] arr1 = {98, 65, 54, 30, 16, 9, 4};
        int[] arr2 = {6, 13, 15, 22, 19, 23};
        boolean result = Task1.IsSorted(arr, SortOrder.ASC);
        boolean result1 = Task1.IsSorted(arr1, SortOrder.DESC);
        boolean result2 = Task1.IsSorted(arr2, SortOrder.ASC);
        assertTrue(result);
        assertTrue(result1);
        assertFalse(result2);
    }
}