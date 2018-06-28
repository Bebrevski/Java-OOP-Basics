package task8_MilitaryElite;

public class Mission {
    private String mission;
    private String state;

    public Mission(String mission, String state) {
        this.mission = mission;
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMission() {
        return this.mission;
    }

    public String getState() {
        return this.state;
    }
}
