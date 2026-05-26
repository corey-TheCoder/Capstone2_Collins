package org.example;

import enums.BreadType;
import enums.SandwichSize;

import java.util.ArrayList;

public class Sandwich extends MenuItems {
    //ARCHETYPE
    private BreadType breadType;
    private SandwichSize size;
    private boolean toasted;
    private ArrayList<Toppings> toppings;

    public Sandwich(BreadType breadType, SandwichSize size, boolean toasted, ArrayList<Toppings> toppings) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString(){
        return size + " " + breadType + " Sandwich (Forged in flame: " + toasted + ")";
    }
}

