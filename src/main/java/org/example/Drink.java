package org.example;

import enums.Affinity;
import enums.DrinkSize;

public class Drink extends MenuItems {
    //potion
    private Affinity affinity;
    private DrinkSize size;

    public Drink(Affinity affinity, DrinkSize size) {
        this.affinity = affinity;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }


    @Override
    public String toString() {
        return size + " " + affinity + " Potion";
    }
}

