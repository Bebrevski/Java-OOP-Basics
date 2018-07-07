package app.entities.colonists;

import app.entities.Colonist;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    public abstract int getPotential();

    @Override
    public String toString() {
        return super.toString();
    }
}
