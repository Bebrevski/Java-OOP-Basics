package controller;

public class Manager {
    private static final Manager GET_INSTANCE = new Manager();

    private static final String EMPTY_STRING = "";



    public Manager() {

    }

    public static Manager getInstance() {
        return GET_INSTANCE;
    }
}
