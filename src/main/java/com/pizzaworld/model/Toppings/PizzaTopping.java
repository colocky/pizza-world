package com.pizzaworld.model.Toppings;

import com.pizzaworld.model.PizzaSize;

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
