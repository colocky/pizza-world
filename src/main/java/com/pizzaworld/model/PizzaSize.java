package com.pizzaworld.model;

public class PizzaSize {
    private String name;
    private int inches;
    private double basePrice;

    public PizzaSize(String name, int inches, double basePrice) {
        this.name = name;
        this.inches = inches;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getInches() {
        return inches;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return name + " " + inches + "\" - $" + String.format("%.2f", basePrice);
    }
}