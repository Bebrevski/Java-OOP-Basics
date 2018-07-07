package app.entities.colonists;

import app.entities.Colonist;

public abstract class Medic extends Colonist {

    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public abstract int getPotential();

    @Override
    public String toString() {
        return super.toString();
    }
}
