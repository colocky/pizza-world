package com.pizzaworld.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;
    private LocalDateTime orderDateTime;
    public Order() {
        this.items = new ArrayList<>();
        this.orderDateTime = LocalDateTime.now();
    }
    public void addItem(OrderItem item) {
        items.add(0, item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    public ArrayList<OrderItem> getItems() {
        return items;
    }
    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }
    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public boolean isValidOrder() {
        return !items.isEmpty();
    }
    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("PIZZA WORLD Receipt\n");
        details.append("·•—–٠✤٠—–•··•—–٠✤٠—–•·\n");
        details.append("Order Time: ").append(orderDateTime).append("\n\n");
        if (items.isEmpty()) {
            details.append("No items in order.\n");
        } else {
            for (int i = 0; i < items.size(); i++) {
                details.append("Item ").append(i + 1).append(":\n");
                details.append(items.get(i).getDetails()).append("\n\n");
            }
        }
        details.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return details.toString();
    }
}
