package app.entities.colonists.engineers;

import app.entities.colonists.Engineer;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int bonus = this.getTalent() + 3;

        if (super.getAge() > 30) {
            bonus += 2;
        }

        if (super.getAge() < 18) {
            return bonus + 2;
        }
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
