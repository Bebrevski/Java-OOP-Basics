package task1_Shapes;

public class Circle implements Drawable {
    private Integer Radius;

    public Circle() {
    }

    public Circle(Integer radius) {
        Radius = radius;
    }

    private Integer getRadius() {
        return this.Radius;
    }

    @Override
    public void draw() {
        double r_in = this.getRadius() - 0.4;

        double r_out = this.getRadius() + 0.4;

        for (double y = this.getRadius(); y >= -this.getRadius(); --y) {

            for (double x = -this.getRadius(); x < r_out; x += 0.5) {

                double value = x * x + y * y;

                if (value >= r_in * r_in && value <= r_out * r_out) {

                    System.out.print("*");

                } else

                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}


