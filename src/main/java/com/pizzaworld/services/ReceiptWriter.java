package com.pizzaworld.services;

import com.pizzaworld.models.Order;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;


public class ReceiptWriter {
    private String receiptDirectory;

    public ReceiptWriter(String receiptDirectory) {
        this.receiptDirectory = receiptDirectory;
    }

    public void saveReceipt(Order order) {
        File folder = new File(receiptDirectory);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")
        String fileName = LocalDateTime.now().format(formatter) + ".txt";
        File receiptFile = new File(folder, fileName);
        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write(order.getOrderDetails());
            System.out.println("Receipt saved: " + receiptFile.getPath());
        } catch (IOException e) {
            System.out.println("Could not save receipt.");
            System.out.println(e.getMessage());
        }
    }
}
