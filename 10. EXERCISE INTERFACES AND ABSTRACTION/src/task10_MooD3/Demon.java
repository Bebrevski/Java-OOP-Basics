package task10_MooD3;

public class Demon extends Base {

    private double specialPoints;

    protected Demon(String username, double specialPoints, int level) {
        super(username, level);
        this.specialPoints = specialPoints;
        this.setHashedPassword();
    }

    public void setHashedPassword() {
        super.setHashPass(String.valueOf(this.getUsername().length() * 217));
    }

    public double getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public String toString() {

        return String.format("\"%s\" | \"%s\" -> %s\n%s"
                , this.getUsername()
                , this.getHashPass()
                , this.getClass().getSimpleName()
                , this.getSpecialPoints() * this.getLevel());
    }
}
