package view;

import controller.CarManager;

public class IOManager {
    public static final IOManager GET_INSTANCE = new IOManager();

    public static IOManager getInstance() {
        return GET_INSTANCE;
    }

    public void run(CarManager manager) {

    }
}
