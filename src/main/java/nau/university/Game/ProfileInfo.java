package nau.university.Game;

import java.util.HashMap;

public class ProfileInfo {

    public void menu(){
        System.out.println("\n1 - Start game");
        System.out.println("2 - See statistics of a specific player");
        System.out.println("3 - See statistics of all players");
    }

    public void profile(){
        System.out.print("Enter login: ");
    }

    public void profile(String login, int attempts) {
        System.out.println("Login: " + login);
        System.out.println("The number of your attempts: " + attempts);
    }

    public void profile(HashMap<String, Integer> allProfiles) {
        for (String key: allProfiles.keySet()){
            System.out.println("The number of " + key + "`s" + " attempts - " + allProfiles.get(key));
        }
    }

    public void menuError(){
        System.out.println("Number is incorrect");
    }

    public void userError(){
        System.out.println("Such user doesn`t exist");
    }
}