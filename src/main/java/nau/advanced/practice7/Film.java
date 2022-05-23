package nau.advanced.practice7;

import java.util.Date;

public class Film {
    private int id;
    private String name;
    private Date date;
    private String country;

    public Film(int id, String name, Date date, String country) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Film{id = " + id + ", name - " + name + ", date - " + date + ", country - " +
                country + "}";
    }
}