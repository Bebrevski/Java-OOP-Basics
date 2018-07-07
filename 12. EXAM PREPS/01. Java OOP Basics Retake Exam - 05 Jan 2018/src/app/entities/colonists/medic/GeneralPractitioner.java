package app.entities.colonists.medic;

import app.entities.colonists.Medic;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int bonus = this.getTalent() + 2;

        if (super.getAge() > 15) {
            bonus += 1;
        }

        if (super.getSign().equals("caring")) {
            bonus += 1;
        } else if (super.getSign().equals("careless")) {
            bonus -= 2;
        }

        return bonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
