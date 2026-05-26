package com.pizzaworld.models;

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


    // This one was really fun to do
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(getName()).append("\n");
        details.append(" Size: ").append(size.getName()).append(" ").append(size.getInches()).append("\"\n");
        details.append(" Crust: ").append(crust.getName()).append("\n");
        details.append(" Stuffed Crust: ").append(stuffedCrust ? "Yes" : "No").append("\n");
        details.append(" Sauces: ");

        if (sauces.isEmpty()) {
            details.append("None");
        } else {
            for (int i = 0; i < sauces.size(); i++) {
                details.append(sauces.get(i).getName());
                if (i < sauces.size() - 1) {
                    details.append(", ");
                }
            }
        }
        details.append("\n");
        details.append(" Toppings: ");
        if (toppings.isEmpty()) {
            details.append("None");
        } else {
            for (int i = 0; i < toppings.size(); i++) {
                details.append(toppings.get(i).getDetails());
                if (i < toppings.size() - 1) {
                    details.append(", ");
                }
            }
        }
        details.append("\n");
        details.append(" Price: $").append(String.format("%.2f", getPrice()));
        return details.toString();
    }
}
