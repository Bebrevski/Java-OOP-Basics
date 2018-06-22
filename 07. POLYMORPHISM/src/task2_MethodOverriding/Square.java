package task2_MethodOverriding;

public class Square extends Rectangle {
    public Square(Double side) {
        super(side);
    }

    @Override
    public Double getArea() {
        return super.getSideA() * super.getSideB();
    }
}
