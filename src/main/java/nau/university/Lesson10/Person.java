package nau.university.Lesson10;

public class Person {
    private String name;
    private String position;
    private double salary;

    public Person(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "\nName = " + name +
                "\nPosition = " + position +
                "\nSalary = " + salary;
    }

    public String getPersonProps() {
        return  name + ";"+
                position + ";" +
                salary + ";";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

}
