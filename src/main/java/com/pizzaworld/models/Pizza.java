package com.pizzaworld.models;

import com.pizzaworld.toppings.CheeseTopping;
import com.pizzaworld.toppings.MeatTopping;
import com.pizzaworld.toppings.RegularTopping;
import com.pizzaworld.toppings.Topping;

import java.util.ArrayList;

public class Pizza implements OrderItem {
    private static final double stuffedCrustPrice = 2.00;

    private PizzaSize size;
    private Crust crust;
    private ArrayList<PizzaTopping> toppings;
    private ArrayList<Sauce> sauces;
    private boolean stuffedCrust;

    public Pizza(PizzaSize size, Crust crust) {
        this.size = size;
        this.crust = crust;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.stuffedCrust = false;
    }

    public void addTopping(PizzaTopping topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public PizzaSize getSize() {
        return size;
    }

    public Crust getCrust() {
        return crust;
    }

    public ArrayList<PizzaTopping> getToppings() {
        return toppings;
    }

    public ArrayList<Sauce> getSauces() {
        return sauces;
    }

    public boolean hasStuffedCrust() {
        return stuffedCrust;
    }

    @Override
    public String getName() {
        return size.getName() + " Pizza";
    }

    @Override
    public double getPrice() {
        double total = size.getBasePrice();

        for (PizzaTopping topping : toppings) {
            total += topping.getPrice(size);
        }

        if (stuffedCrust) {
            total += stuffedCrustPrice;
        }

        return total;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();

        double meatTotal = 0;
        double cheeseTotal = 0;
        double regularTotal = 0;
        double saucesTotal = 0;
        double stuffedTotal = stuffedCrust ? stuffedCrustPrice : 0;

        StringBuilder meatDetails = new StringBuilder();
        StringBuilder cheeseDetails = new StringBuilder();
        StringBuilder regularDetails = new StringBuilder();
        StringBuilder sauceDetails = new StringBuilder();

        for (PizzaTopping pizzaTopping : toppings) {
            Topping topping = pizzaTopping.getTopping();
            double toppingPrice = pizzaTopping.getPrice(size);

            if (topping instanceof MeatTopping) {
                meatTotal += toppingPrice;
                meatDetails.append("  ")
                        .append(String.format("%-24s", pizzaTopping.getDetails()))
                        .append("$ ")
                        .append(String.format("%.2f", toppingPrice))
                        .append("\n");
            } else if (topping instanceof CheeseTopping) {
                cheeseTotal += toppingPrice;
                cheeseDetails.append("  ")
                        .append(String.format("%-24s", pizzaTopping.getDetails()))
                        .append("$ ")
                        .append(String.format("%.2f", toppingPrice))
                        .append("\n");
            } else if (topping instanceof RegularTopping) {
                regularTotal += toppingPrice;
                regularDetails.append("  ")
                        .append(String.format("%-24s", pizzaTopping.getDetails()))
                        .append("$ ")
                        .append(String.format("%.2f", toppingPrice))
                        .append("\n");
            }
        }

        for (Sauce sauce : sauces) {
            sauceDetails.append("  ")
                    .append(String.format("%-24s", sauce.getName()))
                    .append("$ 0.00")
                    .append("\n");
        }

        details.append(size.getName())
                .append(" pizza base:        $")
                .append(String.format("%.2f", size.getBasePrice()))
                .append("\n");

        details.append("Crust:                   ")
                .append(crust.getName())
                .append("\n");

        details.append("Meats:\n");
        if (meatDetails.length() > 0) {
            details.append(meatDetails);
        } else {
            details.append("  None                    $ 0.00\n");
        }
        details.append("Meat total:               $ ")
                .append(String.format("%.2f", meatTotal))
                .append("\n");

        details.append("Cheeses:\n");
        if (cheeseDetails.length() > 0) {
            details.append(cheeseDetails);
        } else {
            details.append("  None                    $ 0.00\n");
        }
        details.append("Cheese total:             $ ")
                .append(String.format("%.2f", cheeseTotal))
                .append("\n");

        details.append("Regular toppings:\n");
        if (regularDetails.length() > 0) {
            details.append(regularDetails);
        } else {
            details.append("  None                    $ 0.00\n");
        }
        details.append("Regular toppings total:   $ ")
                .append(String.format("%.2f", regularTotal))
                .append("\n");

        details.append("Sauces:\n");
        if (sauceDetails.length() > 0) {
            details.append(sauceDetails);
        } else {
            details.append("  None                    $ 0.00\n");
        }
        details.append("Sauces total:             $ ")
                .append(String.format("%.2f", saucesTotal))
                .append("\n");

        details.append("Stuffed crust:            $ ")
                .append(String.format("%.2f", stuffedTotal))
                .append("\n");

        details.append("--------------------------------\n");

        details.append("Total:                    $")
                .append(String.format("%.2f", getPrice()));

        return details.toString();
    }
}