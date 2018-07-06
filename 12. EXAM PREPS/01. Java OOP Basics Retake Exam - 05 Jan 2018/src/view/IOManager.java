package view;

import controller.GalaxyManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOManager {
    private static final IOManager GET_INSTANCE = new IOManager();

    private static final String TERMINATE_COMMAND = "";

    public IOManager() {
    }

    public static IOManager getInstance() {
        return GET_INSTANCE;
    }

    public void run(GalaxyManager manager) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine().trim();

                if (TERMINATE_COMMAND.equals(line)) {
                    break;
                }

                String[] tokens = line.split("\\s+");
                String command = tokens[0];


                switch (command) {

                    default:
                        break;
                }


            }
        }

    }
}
