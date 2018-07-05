package model.cells;

public abstract class Cell implements Comparable<Cell>{
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]"
                , this.id
                , this.positionRow
                , this.positionCol);
    }

    protected abstract int getEnergy();

    public abstract Cell fight(Cell other);

    @Override
    public int compareTo(Cell other) {
        if (Integer.compare(this.positionRow, other.positionRow) == 0) {
            return Integer.compare(this.positionCol, other.positionCol);
        }
        return Integer.compare(this.positionRow, other.positionRow);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return this.health;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }
}
