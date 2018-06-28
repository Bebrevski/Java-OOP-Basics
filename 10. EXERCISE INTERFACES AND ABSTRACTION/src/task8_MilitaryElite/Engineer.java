package task8_MilitaryElite;

import java.util.*;

public class Engineer extends Private implements ISpecialisedSoldier {

    private String corps;
    private Set<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    public void setRepairs(Repair repair) {
        if(this.repairs == null) {
            this.repairs = new LinkedHashSet<>();
        }
        this.repairs.add(repair);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Name: %s %s Id: %s Salary: %.2f%nCorps: %s"
                        , super.getFirstName()
                        , super.getLastName()
                        , super.getId()
                        , this.getSalary()
                        , this.corps))
                .append(System.lineSeparator())
                .append("Repairs:");

        if (this.repairs == null) {
            return sb.toString();
        }

        for (Repair repair : repairs) {
            sb
                    .append(System.lineSeparator())
                    .append("  Part Name: ")
                    .append(repair.getRepair())
                    .append(" Hours Worked: ")
                    .append(repair.getWorkingHours());
        }
        return sb.toString();
    }
}
