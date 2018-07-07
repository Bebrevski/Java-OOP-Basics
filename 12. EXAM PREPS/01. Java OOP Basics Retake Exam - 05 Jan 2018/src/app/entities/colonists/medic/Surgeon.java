package app.entities.colonists.medic;

import app.entities.colonists.Medic;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int bonus = this.getTalent() + 2;

        if (super.getAge() > 25 && super.getAge() < 35) {
            bonus += 2;
        }

        if (super.getSign().equals("precise")) {
            bonus += 3;
        } else if (super.getSign().equals("butcher")) {
            bonus -= 3;
        }

        return bonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
