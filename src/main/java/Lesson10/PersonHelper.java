package Lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PersonHelper {

    static String[][] URLs = {
            {"January 2019", "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/d2b1a7d2-9222-4dfa-b57e-c0bb0b21485b/download/sichen-zp-2019.csv"},
            {"February 2019", "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/38ef4e5e-72ec-4715-95d7-28c0fd42176c/download/liutii-zp-2019.csv"},
            {"March 2019", "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/953aae94-8c82-4296-881f-f57b3a7be389/download/berezen-2019.csv"}
    };

    public static void task(List<Person> persons) throws IOException {
        System.out.println("\n\n");
        printHighestSalary(persons);
        System.out.println("\n\n");
        printPersonsWithLowestSalary(persons);
        System.out.println("\n\n");
        printPersonsWithAverageSalary(persons);
        System.out.println("\n\n");
        printAverageSalaryInEveryMonth(URLs);
        System.out.println("\n\n");
        printMonthWithHighestAverageSalary(URLs);
    }

    public static List<Person> getUsersFromURL(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), Charset.forName("UTF-8")))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                try {
                    persons.add(new Person(
                            words[0],
                            words[1],
                            getParseDouble(words[2])
                    ));
                } catch (ArrayIndexOutOfBoundsException e) {
                    persons.add(new Person(
                            "Error",
                            "Error",
                            0
                    ));
                }
            }
        }
        return persons;
    }

    private static double getParseDouble(String word) {
        word = deleteAllLetters(word);
        try {
            if (word.contains(","))
                return Double.parseDouble(word.replace(",", "."));
            else
                return Double.parseDouble(word);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean isNumberOrPoint(char sign) {
        char[] signs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ','};
        for (char c : signs)
            if (sign == c)
                return true;
        return false;
    }

    private static String deleteAllLetters(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (isNumberOrPoint(word.charAt(i)))
                result.append(word.charAt(i));
        }
        return String.valueOf(result);
    }

    static void printUsers(List<Person> users) {
        for (Person user : users) {
            System.out.println(user.toString());
        }
    }

    public static Person getTheHighestSalary(List<Person> users) {
            Person highest = users.get(0);
            for (int i = 0; i < users.size(); i++) {
                if (highest.getSalary() < users.get(i).getSalary())
                    highest = users.get(i);
            }
        return highest;
        }

    static void printHighestSalary(List<Person> users) {
        Person highest = getTheHighestSalary(users);
        System.out.println("The highest salary has " + highest.getName() + " and it's equal to " + highest.getSalary());
    }

    public static List<Person> getPersonsWithLowestSalary(List<Person> persons) {
        List<Person> lowest = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person temp = persons.get(0);
            for (var user : persons) {
                if (temp.getSalary() > user.getSalary()) {
                    temp = user;
                }
            }
            persons.remove(temp);
            lowest.add(temp);
        }
        return lowest;
    }

    static void printPersonsWithLowestSalary(List<Person> users) {
        users = getPersonsWithLowestSalary(users);
        System.out.println("Top 5 persons with the lowest salary: ");
        printUsers(users);
    }

    static void printPersonsWithAverageSalary(List<Person> users) {
        users = getPersonsWithAverageSalary(users);
        System.out.println("Person with the average salary: ");
        printUsers(users);
    }

    public static List<Person> getPersonsWithAverageSalary(List<Person> users) {
        final double percentOfRange = 0.2;
        double averageSalary = findAverageSalary(users);
        double highestRange = averageSalary + averageSalary * percentOfRange;
        double lowestRange = averageSalary - averageSalary * percentOfRange;

        List<Person> averageMen = new ArrayList<>();
        for (Person user : users) {
            if (user.getSalary() >= lowestRange && user.getSalary() <= highestRange)
                averageMen.add(user);
        }
        return averageMen;
    }

    public static double findAverageSalary(List<Person> users) {
        double averageSalary = 0;
        double sum = 0;
        for (int i = 0; i < users.size(); i++) {
            sum += users.get(i).getSalary();
        }
        averageSalary = round(sum / users.size(), 2);
        return averageSalary;

    }

    static void printAverageSalaryInEveryMonth(String[][] URLs) throws IOException {
        System.out.println("Average salary in every month: \n");
        List<Person> users;
        for (String[] url : URLs) {
            users = getUsersFromURL(url[1]);
            String month = url[0];
            double averageSalary = findAverageSalary(users);
            System.out.println("Average salary in " + month + " is equal to " + averageSalary);
        }
    }

    public static double round(double value, int digits) {
        if (digits < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(digits, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String[] monthWithHighestAverageSalary(String[][] URLs) throws IOException {
        String[] monthAndSalary;
        double highest = 0;
        String month = "";
        List<Person> users;
        for (var item : URLs) {
            users = getUsersFromURL(item[1]);
            double averageSalary = findAverageSalary(users);
            if (averageSalary > highest) {
                highest = averageSalary;
                month = item[0];
            }
        }
        monthAndSalary = new String[] {month, String.valueOf(highest)};
        return monthAndSalary;
    }

    static void printMonthWithHighestAverageSalary(String[][] URLs) throws IOException {
        String[] monthAndSalary = monthWithHighestAverageSalary(URLs);
        System.out.println("The highest average salary was in " + monthAndSalary[0] + " and was equal to " + monthAndSalary[1]);
    }
}
