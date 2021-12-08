package Lesson8;

import java.io.*;
import java.util.*;


public class Duplicates {
    Scanner file;
    private ArrayList<String> text;
    private ArrayList<StringBuilder> duplicates = new ArrayList<>();

    public Duplicates() throws FileNotFoundException {
        file = new Scanner(new File("D:\\Програмування\\Java\\EPAM\\src\\main\\java\\Lesson8\\Task.txt"));
        String str = file.nextLine();
        text = new ArrayList<String>(Arrays.asList(str.split("[ ,.;()\s\n]")));
    }

    public String Duplicates() {
        HashSet<String> hashText = new HashSet<>(text);
        for (String string : hashText) {
            StringBuilder builder = new StringBuilder(string.toUpperCase());
            duplicates.add(builder.reverse());
    }
        String result =
                duplicates.get(1) + "\n" +
                duplicates.get(2) + "\n" +
                duplicates.get(3);

        return result;
    }
}