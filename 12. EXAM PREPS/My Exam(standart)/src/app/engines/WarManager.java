package app.engines;

import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.SuperPower;

import java.util.HashMap;
import java.util.Map;

public class WarManager {

    private Map<String, Arena> arenas = new HashMap<>();
    private Map<String, ComicCharacter> characters = new HashMap<>();
    private Map<String, SuperPower> superPowers = new HashMap<>();

    private int[] battles = new int[2];

    public WarManager() {
    }

    public String checkComicCharacter(String characterName) {
        ComicCharacter current = this.characters.get(characterName);

        if (current == null) {
            return String.format("Sorry, fans! %s doesn't exist in our comics!"
                    , characterName);
        }

        if (current.getHealth() <= 0) {
            return String.format("%s has fallen in battle!%n"
                    , current.getName());
        }

        return current.toString();
    }

    public String addHero(ComicCharacter hero) {
        if (this.characters.get(hero.getName()) == null) {
            this.characters.put(hero.getName(), hero);
            return String.format("%s is ready for battle!%n", hero.getName());
        }

        this.characters.get(hero.getName()).setEnergy(hero.getEnergy());
        this.characters.get(hero.getName()).setHealth(hero.getHealth());
        this.characters.get(hero.getName()).setIntelligence(hero.getIntelligence());

        return String.format("%s evolved!%n", hero.getName());
    }

    public String addAntiHero(ComicCharacter antiHero) {
        if (this.characters.get(antiHero.getName()) == null) {
            this.characters.put(antiHero.getName(), antiHero);
            return String.format("%s is ready for destruction!%n", antiHero.getName());
        }

        this.characters.get(antiHero.getName()).setEnergy(antiHero.getEnergy());
        this.characters.get(antiHero.getName()).setHealth(antiHero.getHealth());
        this.characters.get(antiHero.getName()).setIntelligence(antiHero.getIntelligence());

        return String.format("%s is getting stronger!%n", antiHero.getName());
    }

    public String addArena(Arena arena) {
        if (this.arenas.get(arena.getArenaName()) == null) {
            this.arenas.put(arena.getArenaName(), arena);
            return String.format("%s is becoming a fighting ground!%n"
                    , arena.getArenaName());
        }

        return "A battle is about to start there!\r\n";
    }

    public String addHeroToArena(String arenaName, String hero) {
        Arena arena = this.arenas.get(arenaName);

        for (ComicCharacter character : arena.getHeroes()) {
            if (character.getName().equals(hero)) {
                if (character.getHealth() <= 0) {
                    return String.format("%s is dead!%n", hero);
                }
                return String.format("%s is fighting!%n", hero);
            }
        }

        if (arena.isArenaFull()) {
            return "Arena is full!\r\n";
        }

        arena.addHero(this.characters.get(hero));
        return String.format("%s is fighting for your freedom in %s!%n"
                , hero, arena.getArenaName());
    }

    public String addAntiHeroToArena(String arenaName, String antiHero) {
        Arena arena = this.arenas.get(arenaName);

        for (ComicCharacter character : arena.getHeroes()) {
            if (character.getName().equals(antiHero)) {
                if (character.getHealth() <= 0) {
                    return String.format("%s is dead!%n", antiHero);
                }
                return String.format("%s is fighting!%n", antiHero);
            }
        }

        if (arena.isArenaFull()) {
            return "Arena is full!\r\n";
        }

        arena.addAntiHero(this.characters.get(antiHero));
        return String.format("%s and his colleagues are trying to take over %s!%n"
                , antiHero, arena.getArenaName());
    }

    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowers.get(superPower.getName()) != null) {
            return "This super power already exists!\r\n";
        }

        this.superPowers.put(superPower.getName(), superPower);
        return String.format("%s added to pool!%n", superPower.getName());
    }

    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        if (this.superPowers.get(superPower) == null) {
            return String.format("%s already assigned!%n", superPower);
        }

        this.characters.get(comicCharacter).addSuperPower(this.superPowers.get(superPower));
        this.superPowers.put(superPower, null);
        return String.format("%s has a new super power!%n", comicCharacter);
    }

    public String usePowers(String characterName) {
        if (this.characters.get(characterName).getPowers().isEmpty()) {
            return String.format("%s has no super powers!%n", characterName);
        }

        this.characters.get(characterName).useSuperPowers();
        return String.format("%s used his super powers!%n", characterName);
    }

    public String startBattle(String arena) {
        if (this.arenas.get(arena).isEmptyEmpty()) {
            return "SAFE ZONE!\r\n";
        }

        int heroesWinnings = 0;
        int antiheroesWinnings = 0;

        if (this.arenas.get(arena).fightHeroes()) {
            heroesWinnings++;
        } else {
            antiheroesWinnings++;
        }

        battles[0] = heroesWinnings;
        battles[1] = antiheroesWinnings;

        if (heroesWinnings >= antiheroesWinnings) {
            return String.format("Heroes won the battle of %s!%n", arena);
        } else {
            return String.format("Anti Heroes won the battle of %s!%n", arena);
        }
    }

    public String endWar() {
        if (battles[0] >= battles[1]) {
            return String.format("After %d battles our FRIENDLY HEROES WON!", battles[0]);
        } else {
            return "WE ARE DOOMED!";
        }
    }

}
