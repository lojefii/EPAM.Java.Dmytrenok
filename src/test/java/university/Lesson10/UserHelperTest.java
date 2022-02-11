package university.Lesson10;

import nau.university.Lesson10.Person;
import nau.university.Lesson10.PersonHelper;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.*;

public class UserHelperTest {

    @Test
    void is_Number_Or_Point_True_Test() {
        char[] signs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ','};
        for (char c : signs) {
            assertTrue(PersonHelper.isNumberOrPoint(c));
        }
    }

    @Test
    void is_Number_Or_Point_False_Test() {
        char[] symbols = {'a', '@', '=', '`', '/', '*', ' '};
        for (char c : symbols) {
            Assertions.assertFalse(PersonHelper.isNumberOrPoint(c));
        }
    }

    @Test
    void get_The_Highest_Salary_Test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anton", "", 12000));
        persons.add(new Person("Bohdan", "", 5040));
        persons.add(new Person("Valeriya", "", 14000));
        persons.add(new Person("Volodymyr", "", 9000));
        persons.add(new Person("Valentyn", "", 0));
        Assertions.assertEquals(14000, PersonHelper.getTheHighestSalary(persons).getSalary());
    }

    @Test
    void get_Persons_With_Lowest_Salary_Test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Dmytro", "", 0));
        persons.add(new Person("Petro", "", 4500));
        persons.add(new Person("Tetyana", "", 8000));
        persons.add(new Person("Kyrylo", "", 11000));
        persons.add(new Person("Oleksandra", "", 13200));

        Assertions.assertEquals(Arrays.toString(persons.toArray()), Arrays.toString(PersonHelper.getPersonsWithLowestSalary(persons).toArray()));
    }

    @Test
    void get_Persons_With_Average_Salary_Test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bohdan", "", 7000));

        Assertions.assertEquals(Arrays.toString(persons.toArray()), Arrays.toString(PersonHelper.getPersonsWithAverageSalary(persons).toArray()));
    }

    @Test
    void average_Salary_Test() {
        double average = 8008;
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anton", "", 12000));
        persons.add(new Person("Bohdan", "", 5040));
        persons.add(new Person("Valeriya", "", 14000));
        persons.add(new Person("Volodymyr", "", 9000));
        persons.add(new Person("Valentyn", "", 0));
        Assertions.assertEquals(average, PersonHelper.findAverageSalary(persons));
    }

    @Test
    void round_Test() {
        double value = 1235.9655;
        double newValue = 1235.97;
        Assertions.assertEquals(newValue, PersonHelper.round(value, 2));

        value = 1235.9775;
        newValue = 1235.98;
        Assertions.assertEquals(newValue, PersonHelper.round(value, 2));

        value = 1235.9775;
        newValue = 1236;
        Assertions.assertEquals(newValue, PersonHelper.round(value, 1));

        value = 1235.7356;
        newValue = 1235.7;
        Assertions.assertEquals(newValue, PersonHelper.round(value, 1));
    }

    @Test
    void month_With_Highest_Average_Salary_Test() throws IOException {
        String[][] URLs = new String[][]{
                {"January 2019", "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/d2b1a7d2-9222-4dfa-b57e-c0bb0b21485b/download/sichen-zp-2019.csv"},
                {"February 2019", "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/38ef4e5e-72ec-4715-95d7-28c0fd42176c/download/liutii-zp-2019.csv"}
        };
        String[] monthAndSalary = new String[] {"February 2019", "13650.2"};
        Assertions.assertArrayEquals(monthAndSalary, PersonHelper.monthWithHighestAverageSalary(URLs));
    }
}
