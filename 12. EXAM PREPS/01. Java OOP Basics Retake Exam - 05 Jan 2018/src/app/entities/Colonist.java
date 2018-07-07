package app.entities;

public abstract class Colonist {

    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public void grow(int years) {

    }

    public abstract int getPotential();

    @Override
    public String toString() {
        return super.toString();
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }
}
