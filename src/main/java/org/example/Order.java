package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Order {
    //Quest
    private ArrayList<MenuItems> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public ArrayList<MenuItems> getItems() {
        return items;
    }
    //no setter needed

    public void addItem(MenuItems item){
        items.add(item);
    }
    public double getOrderTotal(){
        double total = 0;

        for(MenuItems item : items){
            total += item.getPrice();
        }
        return total;
    }
    //clearing quest
    public void clearOrder(){
        items.clear();
    }
}
