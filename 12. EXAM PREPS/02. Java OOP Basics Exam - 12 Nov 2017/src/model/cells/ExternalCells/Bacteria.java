package model.cells.ExternalCells;

import model.cells.Microbe;

public class Bacteria extends Microbe {

    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    protected int getEnergy() {
        return (super.getHealth() + super.getVirulence()) / 3;
    }
}
