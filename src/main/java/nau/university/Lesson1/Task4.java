package nau.university.Lesson1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args)
    {
        int num = 0;
        int result = 0;

        try {
            do {
                if (num < 0) {
                    System.out.println("Error! Try again.");
                }
                System.out.print("Enter a positive number: ");
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
            }while(num < 0);
        }
        catch(Exception ex) {
            System.out.print("Error!!! " + ex.getMessage());
            return;
        }

        result = 0;
        while (num > 0) {
            result += num % 2;
            num /= 2;
        }

        System.out.print("Sum of the “1” in the binary representation of number = " + result);
    }
}