package nau.university.Lesson1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner in = new Scanner(System.in);
        int num;

        try {
            num = in.nextInt();

            if(num == 0) {
                System.out.print("0 is just a " + num);
            }
            else if(num > 0) {
                System.out.print("Squared number = " + num * num);
            }
            else if(num < 0) {
                System.out.print("Module of a number = " + num * -1);
            }
        }
        catch(Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}