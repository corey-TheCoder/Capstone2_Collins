package org.example;

import enums.ToppingType;

public class Toppings {
    //Traits
    private String name;
    private ToppingType type;
    private boolean extra;

    public Toppings(String name, ToppingType type, boolean extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    @Override
    public String toString(){
        return (extra ? "Extra" : "") + name + " (" + type + ")";
    }
}
