package model;

import java.util.ArrayList;
import java.util.List;

public class Organism {

    private static final String ORGANISM = "Organism - %s";
    private static final String CLUSTERS_COUNT = "--Clusters: %d";
    private static final String CELLS_COUNT = "--Cells: %d";

    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        clusters = new ArrayList<>();
    }

    public int getClusterCount() {
        return this.clusters.size();
    }

    public int getCellsCount() {
        int cells = 0;
        for (Cluster cluster : this.clusters) {
            cells += cluster.getCellsCount();
        }

        return cells;
    }

    public boolean addCluster(Cluster cluster) {
        for (Cluster current : this.clusters) {
            if (current.getId().equals(cluster.getId())) {
                return false;
            }
        }

        this.clusters.add(cluster);
        return true;
    }

    public Cluster getNextCluster() {
        if (this.clusters.isEmpty()) {
            return null;
        }

        Cluster cluster = clusters.remove(0);
        this.clusters.add(cluster);
        return cluster;
    }

    public Cluster getClusterById(String id) {
        for (Cluster current : this.clusters) {
            if (current.getId().equals(id)) {
                return current;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format(ORGANISM, this.name))
                .append(System.lineSeparator())
                .append(String.format(CLUSTERS_COUNT, this.getClusterCount()))
                .append(System.lineSeparator())
                .append(String.format(CELLS_COUNT, this.getCellsCount()))
                .append(System.lineSeparator());

        for (Cluster cluster : clusters) {
            sb.append(cluster).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
