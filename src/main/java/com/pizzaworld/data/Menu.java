package com.pizzaworld.data;

import com.pizzaworld.model.*;
import com.pizzaworld.model.Toppings.CheeseTopping;
import com.pizzaworld.model.Toppings.MeatTopping;
import com.pizzaworld.model.Toppings.RegularTopping;
import com.pizzaworld.model.Toppings.Topping;

import java.util.ArrayList;

public class Menu {
    public static ArrayList<PizzaSize> getPizzaSizes() {
        ArrayList<PizzaSize> sizes = new ArrayList<>();
        sizes.add(new PizzaSize("Personal", 8, 8.50));
        sizes.add(new PizzaSize("Medium", 12, 12.00));
        sizes.add(new PizzaSize("Large", 16, 16.50));
        return sizes;
    }

    public static ArrayList<Crust> getCrusts() {
        ArrayList<Crust> crusts = new ArrayList<>();
        crusts.add(new Crust("Thin"));
        crusts.add(new Crust("Regular"));
        crusts.add(new Crust("Thick"));
        crusts.add(new Crust("Cauliflower"));
        return crusts;
    }

    public static ArrayList<Topping> getMeatToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(new MeatTopping("Pepperoni"));
        toppings.add(new MeatTopping("Sausage"));
        toppings.add(new MeatTopping("Ham"));
        toppings.add(new MeatTopping("Bacon"));
        toppings.add(new MeatTopping("Chicken"));
        toppings.add(new MeatTopping("Meatball"));
        return toppings;
    }

    public static ArrayList<Topping> getCheeseToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(new CheeseTopping("Mozzarella"));
        toppings.add(new CheeseTopping("Parmesan"));
        toppings.add(new CheeseTopping("Ricotta"));
        toppings.add(new CheeseTopping("Goat Cheese"));
        toppings.add(new CheeseTopping("Buffalo"));
        return toppings;
    }

    public static ArrayList<Topping> getRegularToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(new RegularTopping("Onions"));
        toppings.add(new RegularTopping("Mushrooms"));
        toppings.add(new RegularTopping("Bell Peppers"));
        toppings.add(new RegularTopping("Olives"));
        toppings.add(new RegularTopping("Tomatoes"));
        toppings.add(new RegularTopping("Spinach"));
        toppings.add(new RegularTopping("Basil"));
        toppings.add(new RegularTopping("Pineapple"));
        toppings.add(new RegularTopping("Anchovies"));
        return toppings;
    }

    public static ArrayList<Sauce> getSauces() {
        ArrayList<Sauce> sauces = new ArrayList<>();
        sauces.add(new Sauce("Marinara"));
        sauces.add(new Sauce("Alfredo"));
        sauces.add(new Sauce("Pesto"));
        sauces.add(new Sauce("BBQ"));
        sauces.add(new Sauce("Buffalo"));
        sauces.add(new Sauce("Olive Oil"));
        return sauces;
    }

    public static ArrayList<Topping> getSides() {
        ArrayList<Topping> sides = new ArrayList<>();
        sides.add(new RegularTopping("Red Pepper"));
        sides.add(new RegularTopping("Parmesan"));
        return sides;
    }

    public static ArrayList<ProductSize> getDrinkSizes() {
        ArrayList<ProductSize> sizes = new ArrayList<>();
        sizes.add(new ProductSize("Small", 2.00));
        sizes.add(new ProductSize("Medium", 2.50));
        sizes.add(new ProductSize("Large", 3.00));
        return sizes;
    }

    public static ArrayList<String> getDrinkFlavors() {
        ArrayList<String> flavors = new ArrayList<>();
        flavors.add("Cola");
        flavors.add("Diet Cola");
        flavors.add("Lemon Lime");
        flavors.add("Root Beer");
        flavors.add("Orange Soda");
        flavors.add("Water");
        return flavors;
    }
}
