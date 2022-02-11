package nau.university.Lesson3;

public class Task1 {
    public static void main(String[] args) {
        int[] arr1 = {4, 8, 11, 19, 37, 85};
        int[] arr2 = {1, 3, 9, 5, 12, 28, 17};
        int[] arr3 = {103, 79, 50, 42, 20, 9};
        int[] arr4 = {19, 13, 5, 97, 11, 43};

        System.out.println("Array is sorted? - " + IsSorted(arr1, SortOrder.ASC));
        System.out.println("Array is sorted? - " + IsSorted(arr2, SortOrder.ASC));
        System.out.println("Array is sorted? - " + IsSorted(arr3, SortOrder.DESC));
        System.out.println("Array is sorted? - " + IsSorted(arr4, SortOrder.DESC));
    }

    public static boolean IsSorted(int[] arr, SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASC) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1])
                    return false;
            }
        }
        else if (sortOrder == SortOrder.DESC) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1])
                    return false;
            }
        }
        return true;
    }
}