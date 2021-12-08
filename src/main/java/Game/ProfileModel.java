package Game;

public class ProfileModel {
    private String login;
    private int attempts;

    public ProfileModel(String login) {
        this.login = login;
        this.attempts = 0;
    }

    public String getLogin() {
        return login;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}