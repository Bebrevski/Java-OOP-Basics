package task3_Shapes;

public class Circle extends Shape {

    private double Radius;

    public Circle(double radius) {
        this.Radius = radius;

        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.Radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.pow(this.Radius, 2) * Math.PI);
    }
}
