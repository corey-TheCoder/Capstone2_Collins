package enums;

import org.example.Drink;

public enum DrinkSize {
    Minor(2.00),
    Greater(2.50),
    Legendary(3.00);

    private final double price;

    DrinkSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
