package nau.university.Game;

import java.util.ArrayList;

public class Info {
    public void task() {
        System.out.println("Enter the number to guess a random number from 0 to 100");
    }

    public void bigger(ArrayList<Integer> stat) {
        System.out.println("\tYour previous attempts - " + stat);
        System.out.println("\t\tEnter a bigger number");
    }

    public void smaller(ArrayList <Integer> stat) {
        System.out.println("\tYour previous attempts - " + stat);
        System.out.println("\t\tEnter a smaller number");
    }

    public void info(int min, int max) {
        System.out.println("\t\t\tTip! The random number is between " + min + " and " + max);
    }

    public void win(int num, ArrayList <Integer> stat){
        System.out.println("\t\tYou win! The correct number is " + num);
        System.out.println("\tAll of your attempts - " + stat);
    }

    public void outOfRange() {
        System.out.println("This number is out of range");
    }
}