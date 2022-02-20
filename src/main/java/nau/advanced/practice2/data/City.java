package nau.advanced.practice2.data;

public class City {
    private String name;
    private String country;
    private String population;

    public City(String name, String country, String population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public City() {
        this("City X", "Country X", "0");
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "\nCity{" +
                "name - " + name +
                ", country - " + country +
                ", population = " + population +
                "}";
    }
}
