package enums;

public enum ToppingType {
    //constants for toppings
    MEAT("Rare Enhancements"),
    CHEESE("Arcane Infusions"),
    OTHER_TOPPINGS("Traits"),
    SAUCE("Enhancements"),
    SIDE("Armor");

    private final String displayName;

    ToppingType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}
