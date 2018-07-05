package model;

import model.cells.Cell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("----Cluster %s",this.getId()))
                .append(System.lineSeparator());

        this.cells.sort(Comparator.naturalOrder());
        for (Cell cell : this.cells) {
         sb.append(cell.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    public int getCellsCount() {
        return this.cells.size();
    }

    public String getId() {
        return this.id;
    }

    public boolean addCell(Cell cell) {
        if (cell.getPositionRow() > this.rows || cell.getPositionCol() > this.cols) {
            return false;
        }
        this.cells.add(cell);
        return true;
    }

    //to check
    public void activate() {
        if (this.cells.size() > 1) {
            this.cells.sort(Comparator.naturalOrder());

            Cell actor = this.cells.get(0);

            for (int i = 1; i < this.cells.size(); i++) {
                actor = actor.fight(this.cells.get(i));
            }

            this.cells.clear();
            this.cells.add(actor);
        }
    }
}
