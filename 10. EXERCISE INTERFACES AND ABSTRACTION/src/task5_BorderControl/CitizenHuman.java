package task5_BorderControl;

public class CitizenHuman implements CitizenBase {
    private String name;
    private Integer age;
    private String id;

    public CitizenHuman(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
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
