package app;

import app.engines.Engine;
import app.engines.Manager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;


public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        Manager manager = new Manager();

        Engine engine = new Engine(inputReader, outputWriter, manager);

        engine.run();
    }
}
