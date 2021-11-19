package Lesson2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.print("Enter the array size: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr  = new int[size];
        int max = 0;
        int result = 0;

        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        for (int cur : arr) {
            max = Math.max(max, cur);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                int dist = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    dist++;
                    if (arr[j] == max) {
                        result = dist;
                    }
                }
                break;
            }
        }
        System.out.println(result);
    }
}