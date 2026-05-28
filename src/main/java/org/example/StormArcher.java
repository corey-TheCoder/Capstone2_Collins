package org.example;


import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;

//Ranger
public class StormArcher extends Sandwich{
    public StormArcher(){
        //veteran, Forged
        super(BreadType.WHEAT, SandwichSize.FOUR_INCH,true);
        //weapon
        addToppings(new Toppings("Elven Bow", ToppingType.MEAT,false));
        //blessing
        addToppings(new Toppings("Golden Vow",ToppingType.CHEESE,false));
        //traits
        addToppings(new Toppings("Lightning Affinity",ToppingType.OTHER_TOPPINGS, false));
        addToppings(new Toppings("Phantom Step",ToppingType.OTHER_TOPPINGS, false));
    }
    @Override
    public String toString(){
        return """
                ========================
                      STORM ARCHER
                =======================
                """ + super.toString();
    }
}
