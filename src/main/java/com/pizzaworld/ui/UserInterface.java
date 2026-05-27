package com.pizzaworld.ui;

import com.pizzaworld.models.Crust;
import com.pizzaworld.models.Drink;
import com.pizzaworld.models.GarlicKnots;
import com.pizzaworld.models.Order;
import com.pizzaworld.models.Pizza;
import com.pizzaworld.models.PizzaSize;
import com.pizzaworld.models.PizzaTopping;
import com.pizzaworld.models.ProductSize;
import com.pizzaworld.models.Sauce;
import com.pizzaworld.services.ReceiptWriter;
import com.pizzaworld.data.Menu;
import com.pizzaworld.toppings.Topping;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order currentOrder;
    private ReceiptWriter receiptWriter;

    public UserInterface() {
        scanner = new Scanner(System.in);
        receiptWriter = new ReceiptWriter("receipts");
    }

    public void showHomeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("\n🍕  WELCOME TO PIZZA-WORLD  🍕");
            System.out.println("════════════════════════════════════");
            System.out.println("1) 🍕 Start a Fresh Order");
            System.out.println("0) 🚪 Exit");

            int choice = readInt("👉 Choose an option: ");

            if (choice == 1) {
                currentOrder = new Order();
                showOrderScreen();
            } else if (choice == 0) {
                running = false;
                System.out.println("🍕 Thanks for visiting Pizza-World!");
                System.out.println("See you next time — stay cheesy! 🧀");
            } else {
                System.out.println("⚠️ Oops! Please choose one of the listed options.");
            }
        }
    }

    public void showOrderScreen() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n🧾  YOUR ORDER  🧾");
            System.out.println("════════════════════════════════════");
            System.out.println("Items in Cart: " + currentOrder.getItems().size());
            System.out.println("Current Total: $" + String.format("%.2f", currentOrder.getTotal()));
            System.out.println("1) 🍕 Build Your Pizza");
            System.out.println("2) 🥤 Add a Drink");
            System.out.println("3) 🧄 Add Garlic Knots");
            System.out.println("4) ✅ Checkout");
            System.out.println("0) ❌ Cancel Order");

            int choice = readInt("👉 Choose an option: ");

            if (choice == 1) {
                showAddPizzaScreen();
            } else if (choice == 2) {
                showAddDrinkScreen();
            } else if (choice == 3) {
                showAddGarlicKnotsScreen();
            } else if (choice == 4) {
                boolean completed = showCheckoutScreen();

                if (completed) {
                    ordering = false;
                }
            } else if (choice == 0) {
                currentOrder = null;
                ordering = false;
                System.out.println("❌ Order cancelled. No worries — maybe next time!");
            } else {
                System.out.println("⚠️ Oops! Please choose one of the listed options.");
            }
        }
    }

    public void showAddPizzaScreen() {
        System.out.println("\n🍕  BUILD YOUR PERFECT PIZZA  🍕");
        System.out.println("════════════════════════════════════");

        PizzaSize size = chooseFromList(Menu.getPizzaSizes(), "Choose your pizza size:");
        Crust crust = chooseFromList(Menu.getCrusts(), "Choose your crust style:");

        Pizza pizza = new Pizza(size, crust);

        addToppingsFromCategory(pizza, Menu.getMeatToppings(), "🥓 Meat Toppings");
        addToppingsFromCategory(pizza, Menu.getCheeseToppings(), "🧀 Cheese Toppings");
        addToppingsFromCategory(pizza, Menu.getRegularToppings(), "🥬 Veggie & Classic Toppings");

        addSauces(pizza);

        boolean stuffed = readYesNo("🧀 Add stuffed crust? (y/n): ");
        pizza.setStuffedCrust(stuffed);

        currentOrder.addItem(pizza);
        System.out.println("✅ Pizza added! That masterpiece is in your order.");
    }

    public void showAddDrinkScreen() {
        System.out.println("\n🥤  ADD A DRINK  🥤");
        System.out.println("════════════════════════════════════");

        ProductSize size = chooseFromList(Menu.getDrinkSizes(), "Choose your drink size:");
        String flavor = chooseFromList(Menu.getDrinkFlavors(), "Choose your drink flavor:");

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);

        System.out.println("✅ Drink added! Refreshment secured.");
    }

    public void showAddGarlicKnotsScreen() {
        System.out.println("\n🧄  ADD GARLIC KNOTS  🧄");
        System.out.println("════════════════════════════════════");

        int quantity = readInt("Enter quantity: ");

        while (quantity <= 0) {
            System.out.println("⚠️ Please enter a quantity greater than 0.");
            quantity = readInt("Enter quantity: ");
        }

        GarlicKnots garlicKnots = new GarlicKnots(quantity);
        currentOrder.addItem(garlicKnots);

        System.out.println("✅ Garlic knots added! A tasty choice.");
    }

    public boolean showCheckoutScreen() {
        System.out.println("\n🧾  CHECKOUT  🧾");
        System.out.println("════════════════════════════════════");
        System.out.println(currentOrder.getOrderDetails());

        if (!currentOrder.isValidOrder()) {
            System.out.println("⚠️ Your cart is still empty.");
            System.out.println("Please add at least one delicious item before checkout.");
            return false;
        }

        System.out.println("1) ✅ Confirm Order");
        System.out.println("0) ❌ Cancel Order");

        int choice = readInt("👉 Choose an option: ");

        if (choice == 1) {
            receiptWriter.saveReceipt(currentOrder);
            currentOrder = null;
            System.out.println("🎉 Order complete! Your receipt has been saved.");
            return true;
        } else if (choice == 0) {
            currentOrder = null;
            System.out.println("❌ Order cancelled. No worries — maybe next time!");
            return true;
        } else {
            System.out.println("⚠️ Oops! Please choose one of the listed options.");
            return false;
        }
    }

    private void addToppingsFromCategory(Pizza pizza, ArrayList<Topping> toppings, String title) {
        boolean adding = true;

        while (adding) {
            System.out.println("\n" + title);
            System.out.println("0) ✅ Done");

            for (int i = 0; i < toppings.size(); i++) {
                System.out.println((i + 1) + ") " + toppings.get(i).getName());
            }

            int choice = readInt("Choose a topping: ");

            if (choice == 0) {
                adding = false;
            } else if (choice >= 1 && choice <= toppings.size()) {
                Topping topping = toppings.get(choice - 1);

                boolean extra = readYesNo("Make it extra " + topping.getName() + "? (y/n): ");

                pizza.addTopping(new PizzaTopping(topping, extra));

                if (extra) {
                    System.out.println("Extra " + topping.getName() + " added. ✅");
                } else {
                    System.out.println(topping.getName() + " added. ✅");
                }
            } else {
                System.out.println("⚠️ Please choose a topping from the list.");
            }
        }
    }

    private void addSauces(Pizza pizza) {
        ArrayList<Sauce> sauces = Menu.getSauces();
        boolean adding = true;

        while (adding) {
            System.out.println("\n🥫 Sauces");
            System.out.println("0) ✅ Done");

            for (int i = 0; i < sauces.size(); i++) {
                System.out.println((i + 1) + ") " + sauces.get(i).getName());
            }

            int choice = readInt("Choose a sauce: ");

            if (choice == 0) {
                adding = false;
            } else if (choice >= 1 && choice <= sauces.size()) {
                Sauce sauce = sauces.get(choice - 1);
                pizza.addSauce(sauce);
                System.out.println(sauce.getName() + " added. ✅");
            } else {
                System.out.println("⚠️ Please choose a sauce from the list.");
            }
        }
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number.");
            }
        }
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private boolean readYesNo(String prompt) {
        while (true) {
            String input = readString(prompt).trim();

            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("⚠️ Please enter y or n.");
        }
    }

    private <T> T chooseFromList(ArrayList<T> items, String prompt) {
        while (true) {
            System.out.println(prompt);

            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ") " + items.get(i));
            }

            int choice = readInt("👉 Choose an option: ");

            if (choice >= 1 && choice <= items.size()) {
                return items.get(choice - 1);
            }

            System.out.println("⚠️ Oops! Please choose one of the listed options.");
        }
    }
}