package net.java.main.handlers;

import net.java.main.constants.ExeptionMessagesConstats;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.factories.SpellFactory;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;

public class CarrierCombatHandler extends BaseCommandHandler {

    private int spellCount;

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Spell spell = SpellFactory.createSpell(SpellType.BULLET_RAIN, super.getUnit().getAttackPoints());

        Unit unit = super.getUnit();

        this.spellCount++;

        if (this.spellCount % 3 == 0) {
            return spell;
        } else {
            if (unit.getHealthPoints() <= spell.getEnergyCost()) {
                throw new NotEnoughEnergyException(
                        ExeptionMessagesConstats.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE
                );
            }
        }

        unit.setEnergyPoints(unit.getEnergyPoints() - spell.getEnergyCost());

        return spell;
    }
}
