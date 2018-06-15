package Task9;

class Parent {
    private String Name;
    private String Birthday;

    Parent(String name, String birthday) {
        Name = name;
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n"
                , this.Name
                , this.Birthday);
    }
}
