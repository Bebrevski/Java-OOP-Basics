package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// NOT GOOD SOLUTION -> TO BE FIXED


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> record = new HashMap<>();

        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];

            if (command.equals("Team")) {
                String name = tokens[1];

                try {
                    Team team = new Team(name);
                    record.put(name, team);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

            } else if (command.equals("Add")) {
                String teamName = tokens[1];
                try {
                    Player player = new Player(
                            tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7])
                    );

                    record.get(teamName).addPlayer(player);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (command.equals("Remove")) {
                String team = tokens[1];
                String player = tokens[2];

                try {
                    record.get(team).removePlayer(player);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (command.equals("Rating")) {
                String team = tokens[1];

                if(!record.containsKey(team)) {
                    System.out.println("Team [team name] does not exist.");
                    input = reader.readLine();
                    continue;
                }

                System.out.println(record.get(team).getAverageRating());
            }


            input = reader.readLine();
        }
    }
}
