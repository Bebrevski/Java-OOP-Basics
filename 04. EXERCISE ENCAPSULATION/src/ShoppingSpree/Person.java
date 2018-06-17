package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    private String Name;
    private double Money;
    private List<Product> Products;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.Products = new ArrayList<>();
    }

    private String getName() {
        return this.Name;
    }

    private void setName(String name) {
        if (name.matches("\\s+") || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.Name = name;
    }

    private double getMoney() {
        return this.Money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.Money = money;
    }

    private List<Product> getProducts() {
        return Collections.unmodifiableList(this.Products);
    }

    void addProduct(Product product) {
        if (product.getPrice() > this.getMoney()) {
            String message = String.format("%s can't afford %s"
                    , this.getName()
                    , product.getName());

            throw new IllegalArgumentException(message);
        }

        this.Products.add(product);
        this.setMoney(this.getMoney() - product.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");

        if (this.getProducts().size() == 0) {
            sb.append("Nothing bought");

            return sb.toString();
        }

        for (Product product : this.getProducts()) {
            sb.append(product).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);

        return sb.toString();
    }
}
