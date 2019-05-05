package homework.lesson03.smartBride;

public class Suitor {

    public Suitor(String name, int iq) {
        this.name = name;
        this.iq = iq;
    }

    private String name;
    private int iq;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override

    public String toString() {
        return name + " " + iq;
    }
}
