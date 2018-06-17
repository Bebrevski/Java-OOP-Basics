package ShoppingSpree;

class Product {
    private String Name;
    private double Price;

    Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    String getName() {
        return this.Name;
    }

    private void setName(String name) {
        if (name.matches("\\s+") || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.Name = name;
    }

    double getPrice() {
        return this.Price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.Price = price;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
