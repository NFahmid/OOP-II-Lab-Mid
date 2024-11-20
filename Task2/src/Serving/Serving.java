package Serving;

public abstract class Serving {
    private String name;
    private double price;

    public Serving(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

