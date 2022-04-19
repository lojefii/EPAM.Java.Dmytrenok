package nau.advanced.practice3.task3.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PairStringList stringList = new PairStringList();
        stringList.add("Five");
        stringList.add("Two");
        stringList.add("One");
        System.out.println("String list after adding: " + Arrays.toString(stringList.toArray()));

        stringList.add("Seven", 2);
        System.out.println("String list after adding elements by index: " + Arrays.toString(stringList.toArray()));

        ArrayList list = new ArrayList<String>();
        list.add("Three");
        list.add("Four");

        stringList.addAll(list);
        System.out.println("String list after adding elements from list: " + Arrays.toString(stringList.toArray()));

        list.clear();
        stringList.remove("Three");
        stringList.remove("Four");
        list.add("Nine");
        list.add("Six");
        stringList.addAll(list, 5);
        System.out.println("String list after adding elements from list by index: " + Arrays.toString(stringList.toArray()));

        stringList.remove(8);
        System.out.println("String list after removing elements by index: " + Arrays.toString(stringList.toArray()));

        stringList.remove("Two");
        System.out.println("String list after removing elements by value: " + Arrays.toString(stringList.toArray()));

        System.out.println("Size of string list: " + stringList.size());

        stringList.clear();
        System.out.println("String list after clearing: " + Arrays.toString(stringList.toArray()));
    }
}
