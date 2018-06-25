package task3_CarShopExtended;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Germany", 1000.1);

        Rentable audi = new Audi("A5", "Blue", 210, "Germany", 3, 99.9);

        System.out.println(seat);
        System.out.println(audi);
    }
}
