package task3_Ferrari;

public class Ferrari implements Car {

    private String name;

    public Ferrari(String name) {
        this.name = name;
    }

    @Override
    public String getDriver() {
        return this.name;
    }

    @Override
    public String brake() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s"
                , MODEL
                , this.brake()
                , this.gas()
                , this.getDriver());
    }
}
