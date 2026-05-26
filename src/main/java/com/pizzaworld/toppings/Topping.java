package com.pizzaworld.toppings;

import com.pizzaworld.models.PizzaSize;

public abstract class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice(PizzaSize size, Boolean extra);

    @Override
    public String toString() {
        return name;
    }
}
