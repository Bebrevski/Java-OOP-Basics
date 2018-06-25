package task1_Shapes;

public class Main {
    public static void main(String[] args) {
        Drawable circle = new Circle(10);
        Drawable rect = new Rectangle(4, 3);

        circle.draw();
        rect.draw();
    }
}
