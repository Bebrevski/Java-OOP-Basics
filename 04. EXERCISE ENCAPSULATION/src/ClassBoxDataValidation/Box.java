package ClassBoxDataValidation;

public class Box {
    private double Length;
    private double Width;
    private double Height;

    Box() {
    }

    private double getLength() {
        return this.Length;
    }

    void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.Length = length;
    }

    private double getWidth() {
        return this.Width;
    }

    void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.Width = width;
    }

    private double getHeight() {
        return this.Height;
    }

    void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.Height = height;
    }

    double getSurfaceArea() {
        return 2 * this.getLength() * this.getWidth() +
                2 * this.getLength() * this.getHeight() +
                2 * this.getWidth() * this.getHeight();
    }

    double getLateralSurface() {
        return 2 * this.getLength() * this.getHeight() + 2 * this.getWidth() * this.getHeight();
    }

    double getVolume() {
        return this.getLength() * this.getWidth() * this.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f"
                , this.getSurfaceArea()
                , this.getLateralSurface()
                , this.getVolume());
    }
}
