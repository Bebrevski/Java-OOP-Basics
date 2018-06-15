package Task9;

class Pokemon {
    private String Name;
    private String Type;

    Pokemon(String name, String type) {
        Name = name;
        Type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n"
                , this.Name
                , this.Type);
    }
}
