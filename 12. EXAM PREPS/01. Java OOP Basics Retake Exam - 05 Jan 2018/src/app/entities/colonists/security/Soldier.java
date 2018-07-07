package app.entities.colonists.security;

import app.entities.Colonist;

public class Soldier extends Colonist {
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return this.getTalent() + 2 + 3 + 3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
