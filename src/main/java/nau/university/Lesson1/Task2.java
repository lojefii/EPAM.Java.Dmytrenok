package nau.university.Lesson1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        int[] arr = new int[3];
        int num = 0;
        String result = "";

        try {
            do {
                if (((num < 100 || num > 999) && num != 0)) {
                    System.out.println("Error! Try again.");
                }
                System.out.print("Enter the number (100 <= number <= 999): ");
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
            }
            while (num < 100 || num > 999);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num % 10;
            num /= 10;

        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }

        for (int i = 0; i < 3; i++) {
            result += arr[i];
        }
        System.out.print("Result with the digit of the number in descending order = " + result);

    }
}