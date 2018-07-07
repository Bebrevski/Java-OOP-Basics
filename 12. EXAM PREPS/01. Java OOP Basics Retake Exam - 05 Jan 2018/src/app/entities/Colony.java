package app.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Colony {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new HashMap<>();
    }

    public void addColonist(Colonist colonist) {

    }

    public void removeColonist(String familyId, String memberId) {

    }

    public void removeFamily(String id) {

    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return Collections.unmodifiableList(this.families.get(familyId).getColonistsByFamilyId());
    }

    public void grow(int years) {

    }

    public int getPotential() {
        return 0;
    }

    public String getCapacity() {
        return null;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }
}
