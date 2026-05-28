package org.example;
import org.example.MenuItems;
import org.example.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptManager {
    public void saveReceipt(Order order) {

        try {
            //time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            //file path
            String fileName =
                    now.format(formatter) + ".txt";

            FileWriter writer =
                    new FileWriter("receipts/" + fileName);
            writer.write("""
                    ==========================
                             QUEST
                    ==========================
                    
                    """);
            //print items formatting
            for (MenuItems item : order.getItems()) {
                writer.write(item.toString() + "\n");
                writer.write(String.format(
                        "Price: $%.2f%n%n",
                        item.getPrice()
                ));
            }
            //total formatting
            writer.write(String.format(
                    "TOTAL: $%.2f",
                    order.getOrderTotal()
            ));
            writer.write("------------------\n");
            writer.close();
            System.out.println("Receipt saved successfully!");
        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}

