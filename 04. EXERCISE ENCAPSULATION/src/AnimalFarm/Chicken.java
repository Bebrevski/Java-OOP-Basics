package AnimalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private String Name;
    private int Age;
    private double Eggs;
    private DecimalFormat format;

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);

        this.format = new DecimalFormat("#.#####");
    }

    private String getName() {
        return this.Name;
    }

    private void setName(String name) {
        if (name.matches("\\s+") || name == null) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.Name = name;
    }

    private int getAge() {
        return this.Age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.Age = age;
        this.setEggs();
    }

    private double getEggs() {
        return this.Eggs;
    }

    private void setEggs() {
        if (this.getAge() > 0 && this.getAge() <= 5) {
            this.Eggs = 2;
        } else if (this.getAge() > 5 && this.getAge() <= 11) {
            this.Eggs = 1;
        } else {
            this.Eggs = 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day."
                , this.getName()
                , this.getAge()
                , this.format.format(this.getEggs()));
    }
}
