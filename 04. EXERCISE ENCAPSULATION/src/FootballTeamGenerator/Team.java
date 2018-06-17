package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Team {
    private String Name;
    private Integer AverageRating;
    private List<Player> Players;

    Team(String name) {
        this.setName(name);
        this.AverageRating = 0;
        this.Players = new ArrayList<>();
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

    String getAverageRating() {
        return this.getName() + " - " + this.AverageRating;
    }

    private void setAverageRating(List<Player> players) {
        int sumStats = 0;
        for (Player player : players) {
            sumStats += Math.round(averageStatsOfAPlayer(player.getStats()));
        }
        this.AverageRating = sumStats;
    }

    private Double averageStatsOfAPlayer(Map<String, Integer> stats) {
        return stats
                .values()
                .stream()
                .reduce(0, (a, b) -> a + b) / (double)stats.size();
    }

    private List<Player> getPlayers() {
        return Collections.unmodifiableList(this.Players);
    }

    void addPlayer(Player player) {
        this.Players.add(player);
        setAverageRating(this.getPlayers());
    }

    void removePlayer(String player) {
        boolean hasPlayer = this.Players.stream().anyMatch(p -> p.getName().equals(player));
        if (!hasPlayer) {
            String message = String.format("Player %s is not in %s team."
                    , player
                    , this.getName());
            throw new IllegalArgumentException(message);
        }

        this.Players = this.Players
                .stream()
                .filter(p -> !p.getName().equals(player))
                .collect(Collectors.toList());

        setAverageRating(this.getPlayers());
    }
}
