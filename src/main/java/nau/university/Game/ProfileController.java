package nau.university.Game;

import java.util.HashMap;
import java.util.Scanner;

public class ProfileController {
    private ProfileModel profileModel;
    private ProfileInfo profileInfo;
    HashMap<String, Integer> profiles = new HashMap<>();
    Scanner in = new Scanner(System.in);

    public void startGame() {
        Model gameModel = new Model();
        Info gameView = new Info();
        Controller controller = new Controller(gameModel, gameView);
        controller.game();
        profiles.put(profileModel.getLogin(), profileModel.getAttempts() + gameModel.getStat().size());
        menu();
    }

    public void menu() {

        while (true) {
            profileInfo.menu();
            int scanner = in.nextInt();
            if (scanner == 1) {
                setProfile();
            }
            else if (scanner == 2) {
                profileInfo.profile();
                String login = in.next();
                if (profiles.containsKey(login)) {
                    profileInfo.profile(login, profiles.get(login));
                }
                else {
                    profileInfo.userError();
                }
            } else if (scanner == 3) {
                profileInfo.profile(profiles);
            } else {
                profileInfo.menuError();
            }
        }
    }

    public ProfileController(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public void setProfileModel(String profileLogin, int attempts) {
        this.profileModel = new ProfileModel(profileLogin);
        profileModel.setAttempts(attempts);
    }

    public void setProfile() {
        profileInfo.profile();
        String login = in.next();
        if (profiles.containsKey(login))
            setProfileModel(login, profiles.get(login));
        else
            setProfileModel(login, 0);
        startGame();
    }
}