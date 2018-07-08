package app.engines;

import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.SuperPower;
import app.entities.ArenaImpl;
import app.entities.Power;
import app.entities.hero.DcHero;
import app.entities.hero.MarvelHero;
import app.entities.hero.Titan;
import app.entities.hero.Villain;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utils.Constants;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private WarManager warManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, WarManager warManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.warManager = warManager;
    }

    public void run() {
        while (true) {
            String[] input = this.inputReader.readLine().split("\\s+");

            this.dispatchCommand(input);

            if (Constants.TERMINATE_COMMAND.equals(input[0])) {
                break;
            }
        }
    }

    private void dispatchCommand(String[] input) {
        String command = input[0];

        switch (command) {

            case Constants.CHECK_CHARACTER:

                String charcterName = input[1];

                this.outputWriter.writeLine(warManager.checkComicCharacter(charcterName));
                break;

            case Constants.REGISTER_HERO:

                ComicCharacter hero = createHero(input);

                if (hero != null) {
                    this.outputWriter.writeLine(warManager.addHero(hero));
                }
                break;

            case Constants.REGISTER_ANTI_HERO:

                ComicCharacter antihero = createHero(input);

                if (antihero != null) {
                    this.outputWriter.writeLine(warManager.addAntiHero(antihero));
                }
                break;

            case Constants.BUILD_ARENA:

                try {
                    Arena arena = new ArenaImpl(input[1], Integer.parseInt(input[2]));
                    this.outputWriter.writeLine(warManager.addArena(arena));
                } catch (IllegalArgumentException ex) {
                    this.outputWriter.writeLine(ex.getMessage());
                }
                break;

            case Constants.SEND_HERO:

                this.outputWriter.writeLine(warManager.addHeroToArena(input[1], input[2]));
                break;

            case Constants.SEND_ANTI_HERO:

                this.outputWriter.writeLine(warManager.addAntiHeroToArena(input[1], input[2]));
                break;

            case Constants.SUPER_POWER:
                try {
                    SuperPower superPower = new Power(input[1], Double.parseDouble(input[2]));
                    this.outputWriter.writeLine(warManager.loadSuperPowerToPool(superPower));
                } catch (IllegalArgumentException ex) {
                    this.outputWriter.writeLine(ex.getMessage());
                }
                break;

            case Constants.ASSIGN_POWER:
                this.outputWriter.writeLine(warManager.assignSuperPowerToComicCharacter(input[1], input[2]));
                break;

            case Constants.UNLEASH:
                this.outputWriter.writeLine(warManager.usePowers(input[1]));

            case Constants.COMICS_WAR:
                this.outputWriter.writeLine(warManager.startBattle(input[1]));

            case Constants.TERMINATE_COMMAND:
                this.outputWriter.writeLine(warManager.endWar());
                break;

            default:
                break;
        }
    }

    private ComicCharacter createHero(String[] input) {
        String type = input[2];

        try {
            switch (type) {
                case "DcHero":
                    return new DcHero(
                            input[1],
                            Integer.parseInt(input[3]),
                            Double.parseDouble(input[4]),
                            Double.parseDouble(input[5]),
                            Double.parseDouble(input[6])
                    );
                case "MarvelHero":
                    return new MarvelHero(
                            input[1],
                            Integer.parseInt(input[3]),
                            Double.parseDouble(input[4]),
                            Double.parseDouble(input[5]),
                            Double.parseDouble(input[6])
                    );
                case "Titan":
                    return new Titan(
                            input[1],
                            Integer.parseInt(input[3]),
                            Double.parseDouble(input[4]),
                            Double.parseDouble(input[5]),
                            Double.parseDouble(input[6])
                    );
                case "Villain":
                    return new Villain(
                            input[1],
                            Integer.parseInt(input[3]),
                            Double.parseDouble(input[4]),
                            Double.parseDouble(input[5]),
                            Double.parseDouble(input[6])
                    );
                default:
                    return null;
            }
        } catch (IllegalArgumentException ex) {
            this.outputWriter.writeLine(ex.getMessage());
        }

        return null;
    }
}
