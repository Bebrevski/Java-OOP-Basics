package app.entities.hero;

import app.contracts.ComicCharacter;
import app.entities.ComicCharacterImpl;
import app.utils.Constants;

public abstract class Hero extends ComicCharacterImpl implements ComicCharacter {

    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism < 0D) {
            throw new IllegalArgumentException(Constants.INVALID_HEROISM);
        }
        this.heroism = heroism;
    }

    public double getSpecial() {
        return this.heroism;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s###Heroism: %.2f"
                        , super.toString()
                        , this.getSpecial()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
