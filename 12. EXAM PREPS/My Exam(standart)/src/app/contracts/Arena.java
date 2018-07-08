package app.contracts;

import java.util.List;

public interface Arena {

    String getArenaName();

    boolean isEmptyEmpty();

    boolean isArenaFull();

	void addHero(ComicCharacter hero);

	void addAntiHero(ComicCharacter antiHero);

	boolean fightHeroes();

	List<ComicCharacter> getHeroes();

	List<ComicCharacter> getAntiHeroes();
}
