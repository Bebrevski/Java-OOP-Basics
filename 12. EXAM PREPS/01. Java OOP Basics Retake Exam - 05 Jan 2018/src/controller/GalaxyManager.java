package controller;

public class GalaxyManager {

    private static final GalaxyManager GET_INSTANCE = new GalaxyManager();

    public GalaxyManager() {
        //add collection
    }

    public static GalaxyManager getInstance() {
        return GET_INSTANCE;
    }
}
