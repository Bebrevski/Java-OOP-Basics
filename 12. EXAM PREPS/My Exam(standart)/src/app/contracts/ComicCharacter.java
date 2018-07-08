package app.contracts;

import java.util.List;

public interface ComicCharacter {

    void takeDamage(double damage);

    String getName();

    void boostCharacter(int energy, double health, double intelligence);

    void setName(String name);

    int getEnergy();

    void setEnergy(int energy);

    double getHealth();

    void setHealth(double health);

    double getIntelligence();

    double attack();

    double getSpecial();

    String useSuperPowers();

    void setIntelligence(double intelligence);

    void addSuperPower(SuperPower superPower);

    List<SuperPower> getPowers();
}
