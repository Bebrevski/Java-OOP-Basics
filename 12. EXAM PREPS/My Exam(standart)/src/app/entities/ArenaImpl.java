package app.entities;

import app.contracts.Arena;
import app.contracts.ComicCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArenaImpl implements Arena {

    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isEmptyEmpty() {
        return this.heroes.size() + this.antiHeroes.size() == 0;
    }

    @Override
    public boolean isArenaFull() {
        return this.heroes.size() + this.antiHeroes.size() == this.capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        //TODO
        return false;
    }

    @Override
    public List<ComicCharacter> getHeroes() {
        return Collections.unmodifiableList(this.heroes);
    }

    @Override
    public List<ComicCharacter> getAntiHeroes() {
        return Collections.unmodifiableList(this.antiHeroes);
    }

    public int getCapacity() {
        return this.capacity;
    }
}
