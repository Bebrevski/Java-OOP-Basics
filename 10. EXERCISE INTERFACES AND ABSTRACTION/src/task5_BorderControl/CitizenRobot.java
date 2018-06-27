package task5_BorderControl;

public class CitizenRobot implements CitizenBase {
    private String model;
    private String id;

    public CitizenRobot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId(String finalDigits) {
        if(this.id.endsWith(finalDigits)) {
            return this.id;
        }

        throw new IllegalArgumentException();
    }
}
