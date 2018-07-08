package app.entities.hero;

import app.contracts.ComicCharacter;

public class DcHero extends Hero implements ComicCharacter {
    public DcHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return super.getEnergy() / 1.5 + super.getSpecial() + super.getIntelligence();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s####DC Attack Power: %.2f"
                        , super.toString()
                        , this.attack()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
