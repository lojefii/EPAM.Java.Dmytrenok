package nau.university.Lesson1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

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

        while(num != 0) {
            if((num % 10) % 2 == 1) {
                result += (num % 10);
                num /= 10;
            }
            else {
                num /= 10;
                result += 0;
            }
        }
        System.out.print("The sum of the odd digits of the number = " + result);
    }
}