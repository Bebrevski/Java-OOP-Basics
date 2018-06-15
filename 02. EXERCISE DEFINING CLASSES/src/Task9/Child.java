package Task9;

class Child {
    private String Name;
    private String Birthday;

    Child(String name, String birthday) {
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
