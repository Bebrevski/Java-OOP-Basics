package app.entities.hero;


import app.contracts.ComicCharacter;

public class MarvelHero extends Hero implements ComicCharacter {
    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((super.getEnergy() + super.getSpecial()) * super.getIntelligence()) / 2.5;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s####Marvel Attack Power: %.2f"
                        , super.toString()
                        , this.attack()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
