package app.engines;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private Manager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = manager;
    }

    public void run() {
        while(true) {
            String[] input = this.inputReader.readLine().split("\\s+");

            //INPUT_TERMINATING_COMMAND - this is your terminated command
            if (input.equals("INPUT_TERMINATING_COMMAND")) {
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
