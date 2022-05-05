package nau.advanced.practice6.decorator;

import java.util.ArrayList;
import java.util.List;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i % 2) == 0) {
                list.add(list.get(i));
            }
        }
        return list;
    }
}