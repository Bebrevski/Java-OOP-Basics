package task3_Shapes;

public class Rectangle extends Shape {

    private double Height;
    private double Width;

    public Rectangle(double height, double width) {
        this.Height = height;
        this.Width = width;

        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.Height * 2 + this.Width * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.Width * this.Height);
    }
}
