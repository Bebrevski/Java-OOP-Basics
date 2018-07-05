import controller.CarManager;
import view.IOManager;

public class Main {
    public static void main(String[] args) {
        IOManager.getInstance().run(CarManager.getInstance());
    }
}
