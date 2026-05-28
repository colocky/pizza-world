package com.pizzaworld.model;

import com.pizzaworld.model.Toppings.CheeseTopping;
import com.pizzaworld.model.Toppings.PizzaTopping;
import com.pizzaworld.model.Toppings.RegularTopping;

public class MargheritaPizza extends Pizza {
    public MargheritaPizza() {
        super(new PizzaSize("Medium", 12, 12.00), new Crust("Regular"));

        addTopping(new PizzaTopping(new CheeseTopping("Mozzarella"), false));
        addTopping(new PizzaTopping(new RegularTopping("Tomatoes"), false));
        addTopping(new PizzaTopping(new RegularTopping("Basil"), false));

        addSauce(new Sauce("Marinara"));
        addSauce(new Sauce("Olive Oil"));
    }

    @Override
    public String getName() {
        return "Margherita Signature Pizza";
    }
}