package com.pizzaworld.model;

public class GarlicKnots implements OrderItem {

    private static final double price = 1.50;
    private int quantity;
    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String getName() {
        return "Garlic Knots";
    }
    @Override
    public double getPrice() {
        return price * quantity;
    }
    @Override
    public String getDetails() {
        return getName() + "\n" +
                " Quantity: " + quantity + "\n" +
                " Price: $" + String.format("%.2f", getPrice());
    }
}
