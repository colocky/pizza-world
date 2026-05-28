package com.pizzaworld.model;

public class Drink implements OrderItem{
    private ProductSize size;
    private String flavor;

    public Drink(ProductSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public ProductSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String getName() {
        return size.getName() + " Drink";
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String getDetails() {
        return getName() + "\n" + " Price: $" + String.format("%2f", getPrice());
    }
}
