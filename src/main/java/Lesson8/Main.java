package Lesson8;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("\n\tFirst task\n");
        Frequency frequency = new Frequency();
        frequency.Frequency();
        System.out.print("\n\tSecond task\n");
        Length length = new Length();
        System.out.print(length.Length() + "\n\n");
        System.out.print("\n\tThird task\n");
        Duplicates duplicates = new Duplicates();
        System.out.print(duplicates.Duplicates() + "\n\n");
    }
}
