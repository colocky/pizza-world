package com.pizzaworld.model.Toppings;

import com.pizzaworld.model.PizzaSize;

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
