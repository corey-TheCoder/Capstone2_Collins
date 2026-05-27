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

    public Sandwich(BreadType breadType, SandwichSize size, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
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

    public void addToppings(Toppings topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double price = 0;
        switch (size) {
            //basePrice
            case FOUR_INCH -> {
                price = 5.50;
                break;
            }
            case EIGHT_INCH -> {
                price = 7.00;
                break;
            }
            case FOOT_LONG -> {
                price = 8.50;
                break;
            }
        }
        //toppings
        for(Toppings toppings : toppings) {
            switch (toppings.getType()) {
                //MEAT prices(extra)
                case MEAT:
                    switch (size) {
                        case FOUR_INCH:
                            price += toppings.isExtra() ? 1.50 : 1.00;
                            break;
                        case EIGHT_INCH:
                            price += toppings.isExtra() ? 3.00 : 2.00;
                            break;
                        case FOOT_LONG:
                            price += toppings.isExtra() ? 4.50 : 3.00;
                    }
                    break;
                    //Cheese prices (extra)
                case CHEESE:
                    switch(size){
                        case FOUR_INCH:
                            price += toppings.isExtra()? 1.05 : 0.75;
                            break;
                        case EIGHT_INCH:
                            price += toppings.isExtra()? 2.10 : 1.50;
                            break;
                        case FOOT_LONG:
                            price += toppings.isExtra()? 3.15 : 22.5;
                }
                break;
            }
        }
        return price;
    }
    @Override
    public String toString(){
        String sandwichInfo = size + " " + breadType +
                " Sandwich\n" + "Forged in flame: " +
                (toasted ? "Yes" : "No") + "\n\nToppings:\n";
        for (Toppings toppings : toppings){
            sandwichInfo += "- " + toppings + "\n";
        }
        return sandwichInfo;
    }
}

