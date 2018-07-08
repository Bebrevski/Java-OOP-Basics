package app.entities.hero;

import app.contracts.ComicCharacter;
import app.entities.ComicCharacterImpl;
import app.utils.Constants;

public abstract class AntiHero extends ComicCharacterImpl implements ComicCharacter {

    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness < 0D) {
            throw new IllegalArgumentException(Constants.INVALID_EVILNESS);
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s###Evilness: %.2f"
                        , super.toString()
                        , this.getSpecial()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
