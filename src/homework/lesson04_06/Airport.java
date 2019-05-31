package homework.lesson04_06;

public class Airport {

    private String name = "";
    private City city = null;

    //private int numberOfGates;
    //private int currentNumberOfPlanes;

    public Airport(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}
