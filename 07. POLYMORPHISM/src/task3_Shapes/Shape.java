package task3_Shapes;

public abstract class Shape {
    private double Perimeter;
    private double Area;

    public Shape() {
    }

    public double getPerimeter() {
        return this.Perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.Perimeter = perimeter;
    }

    public double getArea() {
        return this.Area;
    }

    public void setArea(double area) {
        this.Area = area;
    }

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();
}
