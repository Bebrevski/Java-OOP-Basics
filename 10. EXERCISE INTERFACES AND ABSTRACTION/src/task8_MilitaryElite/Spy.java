package task8_MilitaryElite;

public class Spy extends Soldier implements ISpy {

    private String codeNumber;
    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s%nCode Number: %s"
                , super.getFirstName()
                , super.getLastName()
                , super.getId()
                , this.getCodeNumber());
    }
}
