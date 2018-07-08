package app.entities.hero;

import app.contracts.ComicCharacter;

public class Villain extends AntiHero implements ComicCharacter {
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s####Villain Attack Power: %.2f"
                        , super.toString()
                        , this.attack()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
