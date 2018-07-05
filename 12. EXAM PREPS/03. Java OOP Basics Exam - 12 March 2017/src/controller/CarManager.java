package controller;

public class CarManager {

    public static final CarManager GET_INSTANCE = new CarManager();

    public static CarManager getInstance() {
        return GET_INSTANCE;
    }
}
