package nau.advanced.practice8.entities;

import java.util.Objects;

public class Film {
    private int id;
    private String title;
    private int releaseYear;
    private String releaseCounty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getReleaseCounty() {
        return releaseCounty;
    }

    public void setReleaseCounty(String releaseCounty) {
        this.releaseCounty = releaseCounty;
    }

    @Override
    public String toString() {
        return "Film{id = " + getId()  + ", title - " + title + ", year - " + releaseYear +
                ", county - " + releaseCounty + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Film film = (Film) obj;
        return Objects.equals(title, film.getTitle()) && Objects.equals(releaseYear, film.getReleaseYear())
                && Objects.equals(releaseCounty, film.getReleaseCounty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear, releaseCounty);
    }
}
