package task8_MilitaryElite;

public class Repair {
    private String repair;
    private int workingHours;

    public Repair(String repair, int workingHours) {
        this.repair = repair;
        this.workingHours = workingHours;
    }

    public String getRepair() {
        return this.repair;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }
}
