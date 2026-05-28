package com.pizzaworld.model.Toppings;

import com.pizzaworld.model.PizzaSize;

public class RegularTopping extends Topping{
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(PizzaSize size, Boolean extra) {
        return 0;
    }
}
