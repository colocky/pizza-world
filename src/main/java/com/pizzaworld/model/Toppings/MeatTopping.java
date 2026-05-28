package com.pizzaworld.model.Toppings;

import com.pizzaworld.model.PizzaSize;

public class MeatTopping extends Topping {
    public MeatTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(PizzaSize size, Boolean extra) {
        double price = 0;

        if (size.getInches() == 8) {
            price = 1.00;
        } else if (size.getInches() == 12) {
            price = 2.00;
        } else if (size.getInches() == 16) {
            price = 3.00;
        }

        if (extra) {
            if (size.getInches() == 8) {
                price += 0.50;
            } else if (size.getInches() == 12) {
                price += 1.00;
            } else if (size.getInches() == 16) {
                price += 1.50;
            }
        }

        return price;
    }

}
