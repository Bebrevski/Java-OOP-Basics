package FootballTeamGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Player {
    private static final String ENDURANCE = "endurance";
    private static final String SPRINT = "sprint";
    private static final String DRIBBLE = "dribble";
    private static final String PASSING = "passing";
    private static final String SHOOTING = "shooting";

    private String Name;
    private Map<String, Integer> Stats;

    Player(String name, Integer endurance
            , Integer sprint, Integer dribble, Integer passing, Integer shooting) {

        this.setName(name);
        this.setStats(endurance, sprint, dribble, passing, shooting);
    }

    String getName() {
        return this.Name;
    }

    private void setName(String name) {
        if (name.equals("") || name == null || name.matches("\\s+")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.Name = name;
    }

    Map<String, Integer> getStats() {
        return Collections.unmodifiableMap(this.Stats);
    }

    private void setStats(Integer endurance, Integer sprint
            , Integer dribble, Integer passing, Integer shooting) {

        if (!isValid(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        } else if (!isValid(sprint)) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        } else if (!isValid(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        } else if (!isValid(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        } else if (!isValid(shooting)) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }

        this.Stats = new HashMap<>() {{
            put(ENDURANCE, endurance);
            put(SPRINT, sprint);
            put(DRIBBLE, dribble);
            put(PASSING, passing);
            put(SHOOTING, shooting);
        }};
    }

    private boolean isValid(Integer stat) {
        return stat >= 0 && stat <= 100;
    }
}
