package com.pizzaworld.models;

import com.pizzaworld.toppings.CheeseTopping;
import com.pizzaworld.toppings.RegularTopping;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super(new PizzaSize("Personal", 8, 8.50), new Crust("Regular"));

        addTopping(new PizzaTopping(new RegularTopping("Bell Peppers"), false));
        addTopping(new PizzaTopping(new RegularTopping("Spinach"), false));
        addTopping(new PizzaTopping(new RegularTopping("Olives"), false));
        addTopping(new PizzaTopping(new RegularTopping("Onions"), false));
        addTopping(new PizzaTopping(new CheeseTopping("Mozzarella"), false));

        addSauce(new Sauce("Marinara"));
    }

    @Override
    public String getName() {
        return "Veggie Signature Pizza";
    }
}