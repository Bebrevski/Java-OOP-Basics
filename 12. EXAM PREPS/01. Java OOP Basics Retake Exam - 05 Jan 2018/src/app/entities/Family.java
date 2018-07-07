package app.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Family {

    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        colonists = new ArrayList<>();
    }

    public List<Colonist> getColonistsByFamilyId(){
        return Collections.unmodifiableList(this.colonists.stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getId() {
        return this.id;
    }
}
