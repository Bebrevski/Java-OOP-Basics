package app.entities;

import app.contracts.ComicCharacter;
import app.contracts.SuperPower;
import app.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    @Override
    public void takeDamage(double damage) {
        this.health = this.getHealth() - damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        String namePattern = "[a-zA-Z_]+";

        if (!name.matches(namePattern)) {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_NAME);
        }

        if (name.length() < 2 || name.length() > 12) {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_NAME);
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_ENERGY);
        }
        this.energy = energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        if (health < 0D) {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_HEALTH);
        }
        this.health = health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200) {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_INTELLIGENCE);
        }
        this.intelligence = intelligence;
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public String useSuperPowers() {

        for (SuperPower superPower : this.powers) {
            this.energy += superPower.getPowerPoints();
            this.health += superPower.getPowerPoints() * 2;
        }

        return String.format(Constants.USED_SUPER_POWERS, this.getName());
    }

    @Override
    public List<SuperPower> getPowers() {
        return Collections.unmodifiableList(this.powers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("#Name: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f"
                        , this.getHealth()
                        , this.getEnergy()
                        , this.getIntelligence()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
