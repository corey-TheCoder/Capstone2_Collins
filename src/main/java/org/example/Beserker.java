package org.example;

import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;

//classic knight build forged
public class Beserker extends Sandwich{
    public Beserker() {
        super(BreadType.WHITE,
                SandwichSize.EIGHT_INCH,
                true);
        addToppings(new Toppings("Beserker Axe", ToppingType.MEAT,false));
        addToppings(new Toppings("Fire Affinity", ToppingType.OTHER_TOPPINGS,false));
    }

}
