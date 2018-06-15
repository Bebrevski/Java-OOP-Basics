package Task9;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String Name;
    private Car Car;
    private Company Company;
    private List<Parent> Parents;
    private List<Child> Children;
    private List<Pokemon> Pokemons;

    Person() {
        this.Parents = new ArrayList<>();
        Children = new ArrayList<>();
        this.Pokemons = new ArrayList<>();
    }

    void setName(String name) {
        Name = name;
    }

    void setCar(Car car) {
        Car = car;
    }

    void setCompany(Company company) {
        Company = company;
    }

    void addParent(Parent parent) {
        this.Parents.add(parent);
    }

    void addChild(Child child) {
        this.Children.add(child);
    }

    void addPokemon(Pokemon pokemon) {
        this.Pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.Name).append(System.lineSeparator());

        if (this.Company == null) {
            sb.append("Company:").append(System.lineSeparator());
        } else {
            sb.append(this.Company.toString());
        }

        if (this.Car == null) {
            sb.append("Car:").append(System.lineSeparator());
        } else {
            sb.append(this.Car.toString());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : Pokemons) {
            sb.append(pokemon.toString());
        }

        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : Parents) {
            sb.append(parent.toString());
        }

        sb.append("Children:").append(System.lineSeparator());
        for (Child child : Children) {
            sb.append(child.toString());
        }

        return sb.toString();
    }
}
