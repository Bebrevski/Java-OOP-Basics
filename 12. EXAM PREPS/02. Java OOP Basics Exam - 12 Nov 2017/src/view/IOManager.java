package view;

import controller.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOManager {
    private static final IOManager GET_INSTANCE = new IOManager();

    private static final String INPUT_COMMAND = "BEER IS COMING";
    private static final String CREATE_ORGANISM = "createOrganism";
    private static final String ADD_CLUSTER = "addCluster";
    private static final String ADD_CELL = "addCell";
    private static final String ACTIVATE_CLUSTER = "activateCluster";
    private static final String CHECK_CONDITION = "checkCondition";

    public IOManager() {
    }

    public static IOManager getInstance() {
        return GET_INSTANCE;
    }

    public void run(HealthManager manager) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                String line = reader.readLine().trim();

                if (INPUT_COMMAND.equals(line)) {
                    break;
                }

                String[] tokens = line.split("\\s+");
                String command = tokens[0];


                switch (command) {
                    case CREATE_ORGANISM:
                        if (tokens.length == 2) {
                            System.out.print(manager.createOrganism(tokens[1]));
                        }
                        break;
                    case ADD_CLUSTER:
                        if (tokens.length == 5) {
                            System.out.print(manager.addCluster(tokens[1], tokens[2],
                                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                        }
                        break;
                    case ADD_CELL:
                        if (tokens.length == 9) {
                            System.out.print(manager.addCell(tokens[1], tokens[2], tokens[3], tokens[4],
                                    Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]),
                                    Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8])));
                        }
                        break;
                    case ACTIVATE_CLUSTER:
                        if (tokens.length == 2) {
                            System.out.print(manager.activateCluster(tokens[1]));
                        }
                        break;
                    case CHECK_CONDITION:
                        if (tokens.length == 2) {
                            System.out.print(manager.checkCondition(tokens[1]));
                        }
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
