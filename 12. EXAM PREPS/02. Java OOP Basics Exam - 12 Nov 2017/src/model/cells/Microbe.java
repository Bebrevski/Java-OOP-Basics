package model.cells;

public abstract class Microbe extends Cell {

    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return String.format("%s%n--------Health: %d | Virulence: %d | Energy: %d"
                , super.toString()
                , super.getHealth()
                , this.virulence
                , this.getEnergy());
    }

    @Override
    public Cell fight(Cell other) {
        while (true) {
            other.addHealth(-this.getEnergy());

            if (other.getHealth() > 0) {
                this.addHealth(-other.getEnergy());
            } else {
                this.setPositionRow(other.getPositionRow());
                this.setPositionCol(other.getPositionCol());
                return this;
            }

            if (this.getHealth() <= 0) {
                return other;
            }
        }
    }
}
