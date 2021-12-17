package Lesson10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> users = getUsers();
        PersonHelper.task(users);
    }

    public static  List<Person> getUsers() throws IOException {
        List<Person> users = new ArrayList<>();
        for (int i = 0; i < PersonHelper.URLs.length; i++) {
            List<Person> tempList = PersonHelper.getUsersFromURL(PersonHelper.URLs[i][1]);
            users.addAll(tempList);
        }
        return users;
    }
}
