package nau.university.Game;

import nau.university.Game.ProfileController;
import nau.university.Game.ProfileInfo;

public class Program {
    public static void main(String[] args) {
        //Model model = new Model();
        //Info info = new Info();
        //Controller controller = new Controller(model, info);
        //controller.game();
        ProfileInfo profileInfo = new ProfileInfo();
        ProfileController profileController = new ProfileController(profileInfo);
        profileController.menu();
    }
}