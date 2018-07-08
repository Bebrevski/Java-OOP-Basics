package app;

import app.engines.Engine;
import app.engines.WarManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;


public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        WarManager warManager = new WarManager();

        Engine engine = new Engine(inputReader, outputWriter, warManager);

        engine.run();
    }
}
