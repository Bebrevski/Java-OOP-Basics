package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightCommand implements Command {

    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public FightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws GameException {
        List<Unit> killedUnits = new ArrayList<>();

        List<Unit> allLeftUnits = this.unitRepository.findAll()
                .stream()
                .filter(unit -> unit.getHealthPoints() > 0)
                .collect(Collectors.toList());

        if (allLeftUnits.size() < 2) {
            return "Not enough spawns for fight!";
        }

        StringBuilder result = new StringBuilder();
        for (Unit unit : allLeftUnits) {
            Position currentUnitPosition = unit.getPosition();
            int range = unit.getRange();
            int xPos = currentUnitPosition.getX();
            int yPos = currentUnitPosition.getY();

            List<Unit> targets = this.battleground.getUnitsInRange(xPos, yPos, range);

            if (targets.isEmpty()) {
                continue;
            }

            Unit target = unit.getCombatHandler().pickNextTarget(targets);

            Spell spell = unit.getCombatHandler().generateAttack();

            int damageDelta = spell.getDamage() - target.getDefencePoints();

            if (damageDelta > 0) {
                target.setHealthPoints(target.getHealthPoints() - spell.getDamage());

                result.append(String.format("%s cast %s spell and did %d damage"
                        , unit.getName()
                        , spell.getClass().getSimpleName()
                        , spell.getDamage()))
                        .append(System.lineSeparator());

                if (target.getHealthPoints() <= 0) {
                    target.setHealthPoints(0);

                    result.append(String.format("%s killed %s", unit.getName(), target.getName()))
                            .append(System.lineSeparator());

                    killedUnits.add(unit);
                }
            }

        }

        String resultString = result.toString().trim();

        if (resultString.isEmpty()) {
            return "Units are outside range of their enemies, move closer and try again!";
        }

        for (Unit killedUnit : killedUnits) {
            this.battleground.remove(killedUnit);
        }

        return resultString;
    }
}
