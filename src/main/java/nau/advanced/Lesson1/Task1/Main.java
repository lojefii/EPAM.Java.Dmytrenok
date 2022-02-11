package nau.advanced.Lesson1.Task1;

import nau.advanced.Lesson1.Task1.house.House;
import nau.advanced.Lesson1.Task1.residents.cats.*;
import nau.advanced.Lesson1.Task1.residents.dogs.*;

public class Main {
    public static void main(String[] args) {
        Dog cooper = new Dog("Cooper");
        Puppy charlie = new Puppy("Charlie");
        Cat cliff = new Cat("Cliff");
        Kitten chips = new Kitten("Chips");

        House<Dog> dogHouse = new House();
        dogHouse.enter(cooper);
        dogHouse.enter(charlie);
        //dogHouse.enter(cliff); //This line will not be compiled due to a mismatch of resident type
        //dogHouse.enter(chips); //This line will not be compiled due to a mismatch of resident type
        System.out.println(dogHouse);

        House<Cat> catHouse = new House();
        catHouse.enter(cliff);
        catHouse.enter(chips);
        //catHouse.enter(cooper); //This line will not be compiled due to a mismatch of resident type
        //catHouse.enter(charlie); //This line will not be compiled due to a mismatch of resident type
        System.out.println(catHouse);
    }
}
