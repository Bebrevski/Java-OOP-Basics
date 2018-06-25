package task1_Shapes;

public class Rectangle implements Drawable{
    private Integer Width;
    private Integer Height;

    public Rectangle() {
    }

    public Rectangle(Integer width, Integer height) {
        Width = width;
        Height = height;
    }

    private Integer getWidth() {
        return this.Width;
    }

    private Integer getHeight() {
        return this.Height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight(); i++) {

            System.out.print("*");

            for (int j = 1; j < this.getWidth() - 1; j++) {

                System.out.print(" ");

                if (i == 0 || i == (this.getHeight() - 1)) {

                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }

            System.out.print(" ");

            System.out.print("*");

            System.out.println();
        }
    }
}
