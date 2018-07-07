package app;

import app.engines.Engine;
import app.engines.ColonyManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;


public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        ColonyManager colonyManager = new ColonyManager();

        Engine engine = new Engine(inputReader, outputWriter, colonyManager);

        engine.run();
    }
}
