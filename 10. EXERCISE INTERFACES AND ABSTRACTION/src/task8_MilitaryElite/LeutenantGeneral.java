package task8_MilitaryElite;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private Set<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    public void setPrivates(Private person) {
        if (this.privates == null) {
            this.privates = new HashSet<>();
        }

        this.privates.add(person);
    }

    @Override
    public Set<Private> getPrivates() {
        return Collections.unmodifiableSet(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Name: %s %s Id: %s Salary: %.2f"
                        , super.getFirstName()
                        , super.getLastName()
                        , super.getId()
                        , this.getSalary()))
                .append(System.lineSeparator())
                .append("Privates:");

        if (this.privates == null) {
            return sb.toString();
        }

        this.privates.stream()
                .sorted((p1, p2) -> p2.getId().compareTo(p1.getId()))
                .forEach(p -> sb
                        .append(System.lineSeparator())
                        .append("  ").append(p.toString()));

        return sb.toString();
    }
}
