package nau.advanced.practice3.task3.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortedByAbsoluteValueIntegerSet set = new SortedByAbsoluteValueIntegerSet();
        set.add(7);
        set.add(4);
        set.add(12);
        set.add(-2);
        set.add(28);
        set.add(19);
        set.add(-44);
        System.out.println("Set after adding: " + Arrays.toString(set.toArray()));

        set.remove(7);
        System.out.println("Set after removing one element: " + Arrays.toString(set.toArray()));

        ArrayList list = new ArrayList<Integer>();
        for (int i = 13; i < 19; i++) {
            list.add(i - 5);
        }

        set.addAll(list);
        System.out.println("Set after adding elements from list: " + Arrays.toString(set.toArray()));

        set.removeAll(list);
        System.out.println("Set after removing elements from list: " + Arrays.toString(set.toArray()));

        set.clear();
        System.out.println("Set after clearing: " + Arrays.toString(set.toArray()));
    }
}
