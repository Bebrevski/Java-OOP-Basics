package app.engines;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utils.Constants;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private ColonyManager colonyManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, ColonyManager colonyManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.colonyManager = colonyManager;
    }

    public void run() {
        while(true) {
            String[] input = this.inputReader.readLine().split("\\s+");


            if (Constants.TERMINATION_COMMAND.equals(input)) {
                break;
            }

            this.dispatchCommand(input);

        }
    }

    private void dispatchCommand(String[] input) {
        String command = input[0];

        switch(command) {

        }
    }
}
