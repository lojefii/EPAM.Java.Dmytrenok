package nau.advanced.practice7;

import java.util.Date;

public class Person {
    private int id;
    private String fullName;
    private Date date;

    public Person(int id, String fullName, Date date) {
        this.id = id;
        this.fullName = fullName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{id = " + id + ", fullName - " + fullName + ", date - " + date + "}";
    }
}