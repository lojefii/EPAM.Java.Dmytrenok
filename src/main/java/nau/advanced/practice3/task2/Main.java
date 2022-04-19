package nau.advanced.practice3.task2;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        IntStringCappedMap map = new IntStringCappedMap(20);
        map.put(3, "Three");
        map.put(1, "One");
        map.put(6, "Six");
        map.put(2, "Two");
        map.put(5, "Five");
        map.put(4, "Four");
        System.out.println(new TreeMap<>(map));
    }
}
