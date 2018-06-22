package task2_MethodOverriding;

public class Rectangle {
    private Double sideA;
    private Double sideB;

    public Rectangle(Double side) {
        this(side, side);
    }

    public Rectangle(Double sideA, Double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    protected Double getSideA() {
        return this.sideA;
    }

    protected Double getSideB() {
        return this.sideB;
    }

    public Double getArea() {
        return this.sideA * this.sideB;
    }
}
