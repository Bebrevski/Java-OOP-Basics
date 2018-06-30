package net.java.main.factories;

import net.java.main.enums.UnitType;
import net.java.main.interfaces.Position;
import net.java.main.interfaces.Unit;
import net.java.main.models.PositionImpl;
import net.java.main.models.units.Carrier;
import net.java.main.models.units.Marine;

public final class UnitFactory {

    private UnitFactory(){}

    public static Unit createUnit(UnitType unitType, String name, int xPos, int yPos) {

        Position position;

        switch (unitType) {
            case CARRIER:
                position = new PositionImpl(xPos, yPos);

                return new Carrier(
                        name,
                        position,
                        CombatHandlerFactory.createCarrierCombatHandler());
            case MARINE:
                position = new PositionImpl(xPos, yPos);

                return new Marine(
                        name,
                        position,
                        CombatHandlerFactory.createMarineCombatHandler());
            default:
                return null;
        }
    }
}
