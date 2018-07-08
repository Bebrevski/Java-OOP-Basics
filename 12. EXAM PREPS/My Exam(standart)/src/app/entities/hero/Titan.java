package app.entities.hero;

import app.contracts.ComicCharacter;

public class Titan extends AntiHero implements ComicCharacter {
    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getEnergy() + super.getIntelligence() + super.getSpecial())  * 3;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s####Titan Attack Power: %.2f"
                        , super.toString()
                        , this.attack()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
