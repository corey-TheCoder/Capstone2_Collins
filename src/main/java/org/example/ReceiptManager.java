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
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName =
                    now.format(formatter) + ".txt";
            FileWriter writer =
                    new FileWriter("receipts/" + fileName);
            writer.write("""
                    ==========================
                             QUEST
                    ==========================
                    
                    """);
            for (MenuItems item : order.getItems()) {
                writer.write(item.toString() + "\n");
                writer.write(String.format(
                        "Price: $%.2f%n%n",
                        item.getPrice()
                ));
            }
            writer.write(String.format(
                    "TOTAL: $%.2f",
                    order.getOrderTotal()
            ));
            writer.close();
        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}

