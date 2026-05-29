package org.example;


import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;

//Shadow Monk
public class ShadowMonk extends Sandwich{
    public ShadowMonk(){
        //warlock legendary, not forged
        super(BreadType.RYE, SandwichSize.FOOT_LONG, false);
        //weapon
        addToppings(new Toppings("Twin Daggers", ToppingType.MEAT, false));
        //blessings
        addToppings(new Toppings("Black Flame Protection", ToppingType.CHEESE,false));
        //traits
        addToppings(new Toppings("Shadow Clones",ToppingType.OTHER_TOPPINGS, false));
        addToppings(new Toppings("Silent Step",ToppingType.OTHER_TOPPINGS, false));
        //ability
        addToppings(new Toppings("Phantom Step",ToppingType.SAUCE, false));
    }
//    @Override
//    public String toString(){
//        return """
//                ========================
//                      SHADOW MONK
//                =======================
//                """ + super.toString();

}
