package task8_MilitaryElite;

import java.util.*;

public class Commando extends Private implements ISpecialisedSoldier {

    private static final String AIRFORCES = "Airforces";
    private static final String MARINES = "Marines";

    private static final String FINISHED_MISSION = "finished";
    private static final String MISSION_IN_PROGRESS = "inProgress";

    private String corps;
    private List<Mission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!MARINES.equals(corps) && !AIRFORCES.equals(corps)) {
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }

    public void setMissions(Mission mission) {
        if (this.missions == null) {
            this.missions = new ArrayList<>();
        }
        this.missions.add(mission);
    }

    public void completeMission(Mission mission) {
        if (this.missions == null) {
            this.missions = new ArrayList<>();
        }

        for (Mission m : missions) {
            if (m.getMission().equals(mission.getMission()) &&
                    m.getState().equals(MISSION_IN_PROGRESS) &&
                    mission.getState().equals(FINISHED_MISSION)) {
                m.setState(FINISHED_MISSION);
            }
        }
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Name: %s %s Id: %s Salary: %.2f%nCorps: %s"
                        , super.getFirstName()
                        , super.getLastName()
                        , super.getId()
                        , this.getSalary()
                        , this.corps))
                .append(System.lineSeparator())
                .append("Missions:");

        if (this.missions == null) {
            return sb.toString();
        }

        for (Mission mission : missions) {
            if(mission.getState().equals(MISSION_IN_PROGRESS)) {
                sb
                        .append(System.lineSeparator())
                        .append("  Code Name: ")
                        .append(mission.getMission())
                        .append(" State: ")
                        .append(mission.getState());
            }
        }
        return sb.toString();
    }
}
