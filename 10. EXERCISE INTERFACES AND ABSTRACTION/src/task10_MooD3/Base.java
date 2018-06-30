package task10_MooD3;

public class Base {
    private String username;
    private String hashPass;
    private int level;

    protected Base(String username, int level) {
        this.username = username;
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected String getHashPass() {
        return this.hashPass;
    }

    protected void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    protected int getLevel() {
        return this.level;
    }
}
