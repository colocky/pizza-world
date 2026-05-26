package com.pizzaworld.models;

import com.pizzaworld.toppings.Topping;

public class PizzaTopping {
    private Topping topping;
    private boolean extra;

    public PizzaTopping(Topping topping, boolean extra) {
        this.topping = topping;
        this.extra = extra;
    }

    public Topping getTopping() {
        return topping;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice(PizzaSize size) {
        return topping.getPrice(size, extra);
    }

    public String getDetails() {
        if (extra) {
            return "Extra " + topping.getName();
        }

        return topping.getName();
    }
}
