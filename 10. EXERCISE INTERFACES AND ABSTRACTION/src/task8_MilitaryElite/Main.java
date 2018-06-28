package task8_MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String END_OF_LINES = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> record = new ArrayList<>();

        String input;
        while (!END_OF_LINES.equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String typeOfSoldier = tokens[0];

            switch (typeOfSoldier) {
                case "Private": {
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    Double salary = Double.parseDouble(tokens[4]);

                    Private person = new Private(id, firstName, lastName, salary);
                    record.add(person);
                }
                break;

                case "Spy": {
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    String codeNumber = tokens[4];

                    Spy person = new Spy(id, firstName, lastName, codeNumber);
                    record.add(person);
                }
                break;

                case "LeutenantGeneral": {
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    if (tokens.length < 6) {
                        LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);
                        record.add(leutenantGeneral);
                        continue;
                    }
                    String[] privates = Arrays.copyOfRange(tokens, 5, tokens.length);

                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (String p : privates) {
                        for (Soldier s : record) {
                            if (p.equals(s.getId())) {
                                leutenantGeneral.setPrivates((Private) s);
                            }
                        }
                    }

                    record.add(leutenantGeneral);
                }
                break;

                case "Engineer": {
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    String coprs = tokens[5];

                    if (tokens.length < 7) {
                        Engineer eng = new Engineer(id, firstName, lastName, salary, coprs);
                        record.add(eng);
                        continue;
                    }

                    String[] repairs = Arrays.copyOfRange(tokens, 6, tokens.length);

                    Engineer eng = new Engineer(id, firstName, lastName, salary, coprs);

                    String repair;
                    int workingHours;
                    for (int i = 0; i < repairs.length; i += 2) {
                        repair = repairs[i];
                        workingHours = Integer.parseInt(repairs[i + 1]);

                        Repair rep = new Repair(repair, workingHours);
                        eng.setRepairs(rep);
                    }

                    record.add(eng);
                }
                break;

                case "Commando": {
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    String coprs = tokens[5];

                    if (tokens.length < 7) {
                        Commando com = new Commando(id, firstName, lastName, salary, coprs);
                        record.add(com);
                        continue;
                    }

                    String[] missions = Arrays.copyOfRange(tokens, 6, tokens.length);

                    Commando com = new Commando(id, firstName, lastName, salary, coprs);

                    String mission;
                    String state;
                    for (int i = 0; i < missions.length; i += 2) {
                        mission = missions[i];
                        state = missions[i + 1];

                        Mission miss = new Mission(mission, state);
                        com.completeMission(miss);
                        com.setMissions(miss);
                    }

                    record.add(com);
                }
                break;
            }
        }

        for (Soldier soldier : record) {
            System.out.println(soldier);
        }
    }
}

