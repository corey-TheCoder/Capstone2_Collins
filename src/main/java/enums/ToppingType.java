package enums;

public enum ToppingType {
    //constants for toppings
    MEAT("Weapon"),
    CHEESE("Blessings"),
    OTHER_TOPPINGS("Abilities"),
    SAUCE("Traits"),
    SIDE("Traditions");

    private final String displayName;

    ToppingType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
    @Override
    public String toString(){
        return displayName;
    }
}
