package Lesson8;

import java.util.*;
import java.io.*;

public class Length {
    private Scanner file;
    private ArrayList<String> text;

    public Length() throws FileNotFoundException {
        file = new Scanner(new File("D:\\Програмування\\Java\\EPAM\\src\\main\\java\\Lesson8\\Task.txt"));
        String str = file.nextLine();
        text = new ArrayList<String>(Arrays.asList(str.split("[,.\s\n]")));
    }

    public String Length() {
        text.sort((first, second) -> Integer.compare(second.length(), first.length()));

        String result =
                text.get(0) + " ==> " + text.get(0).length() + "\n" +
                text.get(1) + " ==> " + text.get(1).length() + "\n" +
                text.get(2) + " ==> " + text.get(2).length() + "\n";
        return result;
    }
}