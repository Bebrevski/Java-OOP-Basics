package net.java.main.commands;

import net.java.main.constants.ExeptionMessagesConstats;
import net.java.main.enums.UnitType;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.InvalidUnitTypeExeption;
import net.java.main.exceptions.NoUnitToRemoveExeption;
import net.java.main.factories.UnitFactory;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

public class StatusCommand implements Command {

    private Repository<Unit> unitRepository;

    public StatusCommand(Repository<Unit> unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws NoUnitToRemoveExeption {
        String unitName = args[1];

        Unit unit = this.unitRepository.findByName(unitName);

        if (unit == null) {
            throw new NoUnitToRemoveExeption(
                    String.format("Not exist unit with name %s!", unitName)
            );
        }

        if (unit.getHealthPoints() <= 0) {
            return String.format("Unit with name %s is already dead :("
                    , unit.getName());
        }

        return unit.toString();
    }
}
