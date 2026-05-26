package com.pizzaworld.toppings;

import com.pizzaworld.models.PizzaSize;

public class CheeseTopping extends Topping {
    public CheeseTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(PizzaSize size, Boolean extra) {
        double price = 0;
        if (size.getInches() == 8) {
            price = 0.75;
        } else if (size.getInches() == 12) {
            price = 1.50;
        } else if (size.getInches() == 16) {
            price = 2.25;
        }

        if (extra) {
            if (size.getInches() == 8) {
                price += 0.30;
            } else if (size.getInches() == 12) {
                price += 0.60;
            } else if (size.getInches() == 16) {
                price += 0.90;
            }
        }
        return price;
    }
}
