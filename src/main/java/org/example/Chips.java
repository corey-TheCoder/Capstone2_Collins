package org.example;

public class Chips extends MenuItems{
    //Rations
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        //only the one
        return 1.50;
    }
    @Override
    public String toString(){
        return type + " Rations";
    }
}