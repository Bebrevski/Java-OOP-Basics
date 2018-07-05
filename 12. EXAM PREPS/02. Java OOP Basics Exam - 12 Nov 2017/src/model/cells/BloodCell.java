package model.cells;

public abstract class BloodCell extends Cell {

    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    public final Cell fight(Cell other) {
        this.addHealth(other.getHealth());
        this.setPositionRow(other.getPositionRow());
        this.setPositionCol(other.getPositionCol());

        return this;
    }
}
