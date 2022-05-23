package nau.advanced.practice8.entities;

import java.util.Objects;

public class Actor {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birdsYear) {
        this.birthYear = birdsYear;
    }

    @Override
    public String toString() {
        return "Actor{id = " + getId() + ", firstName - " + firstName + ", lastName - " +
                lastName + ", year - " + birthYear + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Actor actor = (Actor) obj;
        return Objects.equals(birthYear, actor.getBirthYear()) && Objects.equals(firstName, actor.getFirstName())
                && Objects.equals(lastName, actor.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear);
    }
}
