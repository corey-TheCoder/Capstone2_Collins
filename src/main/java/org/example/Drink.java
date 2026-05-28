package org.example;

import enums.Affinity;
import enums.DrinkSize;

public class Drink extends MenuItems {
    //potion
    private String flavor;
    private DrinkSize size;

    public Drink(Affinity affinity, DrinkSize size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }


    @Override
    public String toString() {
        return size + " " + flavor + " Potion";
    }
}

